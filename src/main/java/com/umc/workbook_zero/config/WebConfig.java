package com.umc.workbook_zero.config;

import com.umc.workbook_zero.validation.validator.ValidPageResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ValidPageResolver validPageResolver;

    public WebConfig(ValidPageResolver validPageResolver) {
        this.validPageResolver = validPageResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(validPageResolver);
    }
}
