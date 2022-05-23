package com.air_research.airwarningsystem.response;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;
import java.util.Collections;

/**
 * @author zwell
 */
@Configuration
public class AirWebConfig implements WebMvcConfigurer {


    /**
     * 跨越
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name())
                .allowCredentials(true)
                .allowedHeaders("*");
    }

    /**
     * 拦截器
     * @return
     */
    @Bean
    public AirInterceptor getAirInterceptor() {
        return new AirInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAirInterceptor()).addPathPatterns("/**")
                // TODO 拦截器生效规则
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**",
                        "/swagger-ui.html/**", "/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    @Bean
    public ServletContextInitializer servletContextInitializer1() {
        return (ServletContext servletContext)
                -> servletContext.setSessionTrackingModes(
                Collections.singleton(SessionTrackingMode.COOKIE));
    }
}
