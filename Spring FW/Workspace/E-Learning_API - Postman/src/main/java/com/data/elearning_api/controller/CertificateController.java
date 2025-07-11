package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.request.CertificateUpdateDTO;
import com.data.elearning_api.dto.response.CertificateResponseDTO;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.service.CertificateService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/certificates")
public class CertificateController {

    CertificateService certificateService;
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("Get all certificates");
        List<Certificate> certificates = certificateService.getAll();
        Type listType = new TypeToken<List<CertificateResponseDTO>>() {}.getType();
        List<CertificateResponseDTO> certificateResponseDTOS = modelMapper.map(certificates, listType);
        return new ResponseEntity<>(certificateResponseDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        log.info("Get certificate by ID: {}", id);
        Certificate certificate = certificateService.getById(id);
        CertificateResponseDTO certificateResponseDTO = modelMapper.map(certificate, CertificateResponseDTO.class);
        return new ResponseEntity<>(certificateResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CertificateCreateDTO dto) {
        log.info("Create certificate with payload: {}", dto);
        Certificate created = certificateService.create(dto);
        CertificateResponseDTO responseDTO = modelMapper.map(created, CertificateResponseDTO.class);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody @Valid CertificateUpdateDTO dto) {
        log.info("Update certificate with ID: {}, payload: {}", id, dto);
        Certificate updated = certificateService.update(id, dto);
        CertificateResponseDTO responseDTO = modelMapper.map(updated, CertificateResponseDTO.class);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        log.info("Delete certificate with ID: {}", id);
        boolean deleted = certificateService.delete(id);
        return ResponseEntity.ok("Xoá thành công");
    }
}