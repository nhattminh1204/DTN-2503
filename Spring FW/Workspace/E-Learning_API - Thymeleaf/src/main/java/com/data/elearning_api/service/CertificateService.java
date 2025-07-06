package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.CertificateCreateDTO;
import com.data.elearning_api.dto.request.CertificateUpdateDTO;
import com.data.elearning_api.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> getAll();
    Certificate getById(int id);
    Certificate create(CertificateCreateDTO dto);
    Certificate update(int id, CertificateUpdateDTO dto);
    boolean delete(int id);
}
