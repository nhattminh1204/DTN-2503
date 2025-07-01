package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.request.CertificateUpdateDTO;
import com.data.elearning_api.entity.Account;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.entity.CertificateType;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.repository.AuthRepository;
import com.data.elearning_api.repository.CertificateRepository;
import com.data.elearning_api.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateServiceImpl implements CertificateService {

    CertificateRepository certificateRepo;
    ModelMapper modelMapper;

    @Override
    public List<Certificate> getAll() {
        return certificateRepo.findAll();
    }

    public Certificate getById(int id) {
        return certificateRepo.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CERTIFICATE_NOT_FOUND));
    }


    @Override
    public Certificate create(CertificateCreateDTO dto) {
        if (certificateRepo.existsByType(dto.getType())) {
            throw new AppException(ErrorCode.CERTIFICATE_TYPE_EXISTS);
        }
        Certificate certificate = modelMapper.map(dto, Certificate.class);
        return certificateRepo.save(certificate);
    }

    @Override
    public Certificate update(int id, CertificateUpdateDTO dto) {
        Certificate existing = getById(id);

        if (!existing.getType().equals(dto.getType()) &&
                certificateRepo.existsByType(dto.getType())) {
            throw new AppException(ErrorCode.CERTIFICATE_TYPE_EXISTS);
        }

        modelMapper.map(dto, existing);
        return certificateRepo.save(existing);
    }

    @Override
    public boolean delete(int id) {
        Certificate cert = getById(id);

        if (cert.getCourses() != null && !cert.getCourses().isEmpty()) {
            throw new AppException(ErrorCode.CERTIFICATE_HAS_COURSES);
        }

        certificateRepo.delete(cert);
        return true;
    }
}