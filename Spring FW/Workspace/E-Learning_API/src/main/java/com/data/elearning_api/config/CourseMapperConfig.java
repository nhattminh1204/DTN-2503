package com.data.elearning_api.config;

import com.data.elearning_api.dto.response.CourseRes;
import com.data.elearning_api.entity.Course;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseMapperConfig {

    @Bean
    public PropertyMap<Course, CourseRes> courseToResMap() {
        return new PropertyMap<Course, CourseRes>() {
            @Override
            protected void configure() {
                map().setCategoryId(source.getCategory().getId());
            }
        };
    }
}
