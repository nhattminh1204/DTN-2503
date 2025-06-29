package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.response.AccountRes;
import com.data.elearning_api.dto.response.CertificateRes;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.service.CertificateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/certificates")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateController {
    final CertificateService certificateService;
    final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllCertificates() {
        List<Certificate> certificates = certificateService.getAll();

        List<CertificateRes> certificateResList = modelMapper
                .map(certificates, new TypeToken<List<CertificateRes>>() {}.getType());

        return new ResponseEntity<>(certificateResList, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCertificateByCourseId(@PathVariable int courseId) {
        List<Certificate> certificates = certificateService.getByCourseId(courseId);

        List<CertificateRes> certificateResList = modelMapper.
                map(certificates, new TypeToken<List<CertificateRes>>() {}.getType());
        return new ResponseEntity<>(certificateResList, HttpStatus.OK);
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<?> createCertificate(@PathVariable int courseId,
                                               @RequestBody CertificateCreateDTO dto) {
        Certificate created = certificateService.create(courseId, dto);

        if (created == null) {
            return new ResponseEntity<>("Invalid courseId or accountId", HttpStatus.BAD_REQUEST);
        }

        CertificateRes certificateRes = modelMapper.map(created, CertificateRes.class);
        return new ResponseEntity<>(certificateRes, HttpStatus.CREATED);
    }
}
