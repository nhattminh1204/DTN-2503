package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.request.CertificateUpdateDTO;
import com.data.elearning_api.entity.*;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.repository.AuthRepository;
import com.data.elearning_api.repository.CertificateRepository;
import com.data.elearning_api.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateServiceImpl implements CertificateService {

    private CertificateRepository certificateRepo;
    private CourseRepository courseRepo;
    private AuthRepository accountRepo;

    @Override
    public List<Certificate> getAll() {
        return certificateRepo.findAll();
    }

    @Override
    public Certificate getById(int id) {
        return certificateRepo.findById(id).orElse(null);
    }

    @Override
    public Certificate create(int courseId, CertificateCreateDTO dto) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new AppException(ErrorCode.COURSE_NOT_FOUND));
        Account account = accountRepo.findById(dto.getAccountId())
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));

        Certificate certificate = new Certificate();
        certificate.setCourse(course);
        certificate.setAccount(account);
        certificate.setScore(dto.getScore());
        certificate.setIssueDate(LocalDate.now());
        certificate.setType(determineType(dto.getScore()));

        return certificateRepo.save(certificate);
    }

    @Override
    public Certificate update(int id, int courseId, CertificateUpdateDTO dto) {
        Certificate existing = getById(id);
        if (existing == null)
            throw new AppException(ErrorCode.CERTIFICATE_NOT_FOUND);

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new AppException(ErrorCode.COURSE_NOT_FOUND));
        Account account = accountRepo.findById(dto.getAccountId())
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));

        existing.setCourse(course);
        existing.setAccount(account);
        existing.setScore(dto.getScore());
        existing.setIssueDate(LocalDate.now());
        existing.setType(determineType(dto.getScore()));

        return certificateRepo.save(existing);
    }

    @Override
    public boolean delete(int id) {
        Certificate cert = getById(id);
        if (cert == null) return false;
        certificateRepo.delete(cert);
        return true;
    }

    private CertificateType determineType(double score) {
        if (score >= 85) return CertificateType.MASTER;
        else if (score >= 70) return CertificateType.PROFESSIONAL;
        else return CertificateType.ASSOCIATE;
    }
}