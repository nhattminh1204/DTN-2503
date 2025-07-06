package com.data.elearning_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    // http://localhost:8080/api/v1/e-learning/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Learning API")
                        .version("1.0")
                        .description("Tài liệu API cho hệ thống học trực tuyến")
                        .contact(new Contact()
                                .name("Nhật Minh")
                                .email("nhatminh@example.com")
                                .url("https://github.com/nhattminh1204")
                        )
                );
    }
}
