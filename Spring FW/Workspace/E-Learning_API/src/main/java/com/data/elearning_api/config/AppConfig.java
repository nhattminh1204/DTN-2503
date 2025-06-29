package com.data.elearning_api.config;

import com.data.elearning_api.dto.response.AccountRes;
import com.data.elearning_api.dto.response.CategoryRes;
import com.data.elearning_api.dto.response.CertificateRes;
import com.data.elearning_api.dto.response.CourseRes;
import com.data.elearning_api.entity.Account;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.entity.Course;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(
            PropertyMap<Account, AccountRes> accountToResMap,
            PropertyMap<Course, CourseRes> courseToResMap,
            PropertyMap<Certificate, CertificateRes> certificateToResMap
    ) {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(accountToResMap);
        mapper.addMappings(courseToResMap);
        mapper.addMappings(certificateToResMap);
        return mapper;
    }
}

