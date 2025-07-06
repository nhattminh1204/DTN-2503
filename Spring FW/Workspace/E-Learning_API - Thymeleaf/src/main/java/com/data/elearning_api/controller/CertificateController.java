package com.data.elearning_api.controller.web;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.request.CertificateUpdateDTO;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.service.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/certificates")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateController {

    CertificateService certificateService;
    ModelMapper modelMapper;

    @GetMapping
    public String listCertificates(Model model) {
        List<Certificate> certificates = certificateService.getAll();
        Type listType = new TypeToken<List<Certificate>>() {}.getType();
        model.addAttribute("certificates", modelMapper.map(certificates, listType));
        return "certificate/certificate-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("certificateCreateDTO", new CertificateCreateDTO());
        return "certificate/certificate-create";
    }

    @PostMapping("/create")
    public String processCreate(@ModelAttribute("certificateCreateDTO") @Valid CertificateCreateDTO dto,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "certificate/certificate-create";
        }
        certificateService.create(dto);
        return "redirect:/certificates";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Certificate cert = certificateService.getById(id);
        model.addAttribute("certificateUpdateDTO", modelMapper.map(cert, CertificateUpdateDTO.class));
        model.addAttribute("id", id);
        return "certificate/certificate-edit";
    }

    @PostMapping("/edit/{id}")
    public String processEdit(@PathVariable int id,
                              @ModelAttribute("certificateUpdateDTO") @Valid CertificateUpdateDTO dto,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "certificate/certificate-edit";
        }
        certificateService.update(id, dto);
        return "redirect:/certificates";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        certificateService.delete(id);
        return "redirect:/certificates";
    }
}
