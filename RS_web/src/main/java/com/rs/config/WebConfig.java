package com.rs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @FileName: CorsConfigurationSource
 * @Date: 2024/8/11:9:36
 * @Description: 跨域请求配置类
 * @Author: RWG
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")  //  允许所有来源
                .allowedMethods("*")         //  允许所有方法
                .allowedHeaders("*")         //  允许所有请求头
                .allowCredentials(true)      //  允许携带 cookie/token
                .maxAge(3600);
    }
}

