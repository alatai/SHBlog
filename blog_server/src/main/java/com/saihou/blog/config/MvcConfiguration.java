package com.saihou.blog.config;

import com.saihou.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * MVC 設定
 * @author saihou
 * @version 1.0
 * @date 2022/02/11 12:54
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {

    /**
     * 静的なリソース
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/img/");
    }

    /**
     * Cross-origin-resource-sharing（オリジン間リソース共有）設定
     * same protocol, domain-name and port（プロトコル、ドメイン、ポート番号）
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        // すべての請求を許可する
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    /**
     * ユーザ登録インターセプター
     */
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    /**
     * インターセプターパス設定
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/data/user");
    }
}
