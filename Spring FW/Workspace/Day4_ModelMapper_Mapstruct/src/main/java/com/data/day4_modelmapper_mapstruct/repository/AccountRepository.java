package com.data.day4_modelmapper_mapstruct.repository;

import com.data.day4_modelmapper_mapstruct.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
