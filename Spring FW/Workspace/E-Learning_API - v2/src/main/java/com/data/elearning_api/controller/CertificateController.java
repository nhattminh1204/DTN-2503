package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.request.CertificateUpdateDTO;
import com.data.elearning_api.dto.response.CertificateDTO;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.service.CertificateService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/certificates")
public class CertificateController {

    CertificateService certificateService;
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Certificate> certificates = certificateService.getAll();

        Type listType = new TypeToken<List<CertificateDTO>>() {}.getType();
        List<CertificateDTO> certificateDTOS = modelMapper.map(certificates, listType);

        return new ResponseEntity<>(certificateDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Certificate certificate = certificateService.getById(id);

        CertificateDTO certificateDTO = modelMapper.map(certificate, CertificateDTO.class);

        return new ResponseEntity<>(certificateDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CertificateCreateDTO dto,
                                    @RequestParam int courseId) {
        Certificate created = certificateService.create(courseId, dto);

        CertificateDTO certificateDTO = modelMapper.map(created, CertificateDTO.class);

        return new ResponseEntity<>(certificateDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                               @RequestParam int courseId,
                                               @RequestBody @Valid CertificateUpdateDTO dto) {
        Certificate updated = certificateService.update(id, courseId, dto);
        CertificateDTO responseDTO = modelMapper.map(updated, CertificateDTO.class);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = certificateService.delete(id);
        if (!deleted)
            throw new AppException(ErrorCode.CERTIFICATE_NOT_FOUND);
        return ResponseEntity.ok("Xoá thành công");
    }
}