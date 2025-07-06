package com.data.elearning_api.repository;

import com.data.elearning_api.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    boolean existsByType(String type);
}
