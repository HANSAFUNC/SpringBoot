package com.ttuan.configuration;

import com.ttuan.security.interceptor.securityInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor());
    }
    //    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("doc.html").addResourceLocations("classpath*:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath*:/META-INF/resources/webjars/");
////        super.addResourceHandlers(registry);
//    }

    @Bean
    public securityInterceptor securityInterceptor() {
        return new securityInterceptor();
    }
}

