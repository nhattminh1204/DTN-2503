package com.data.elearning_api.config;

import com.data.elearning_api.dto.response.AccountRes;
import com.data.elearning_api.entity.Account;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountMapperConfig {
    @Bean
    public PropertyMap<Account, AccountRes> accountToResMap() {
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setRole(source.getRole().name());
            }
        };
    }
}
