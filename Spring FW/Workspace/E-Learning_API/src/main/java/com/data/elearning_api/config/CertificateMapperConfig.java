package com.data.elearning_api.config;

import com.data.elearning_api.dto.response.CertificateRes;
import com.data.elearning_api.entity.Certificate;
import org.modelmapper.PropertyMap;
import org.modelmapper.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CertificateMapperConfig {
    @Bean
    public PropertyMap<Certificate, CertificateRes> certificateToResMap() {
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                using((Converter<Enum<?>, String>) ctx -> ctx.getSource().name())
                        .map(source.getType(), destination.getType());
                map().setAccountId(source.getAccount().getId());
                map().setCourseId(source.getCourse().getId());
            }
        };
    }
}
