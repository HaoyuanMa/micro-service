package com.bhjx.accdoctor.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@RefreshScope
@Configuration
public class AccdoctorCorsConfiguration {

    @Value("${allowedOriginAdmin}")
    private String allowedOriginAdmin;
    @Value("${allowedOriginFront}")
    private String allowedOriginFront;
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin(allowedOriginAdmin);
        corsConfiguration.addAllowedOrigin(allowedOriginFront);
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }

}
