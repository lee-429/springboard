package com.hyunhak.springboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 정적 리소스(파일) 접근 설정
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // uploads 경로 요청을 실제 파일 저장 위치와 연결
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // /uploads/** 요청이 들어오면 프로젝트의 uploads 폴더에서 파일을 찾도록 설정
        registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/");
    }
}
