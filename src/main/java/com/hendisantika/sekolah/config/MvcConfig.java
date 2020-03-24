package com.hendisantika.sekolah.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 05.33
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/dashboard").setViewName("admin/dashboard");
        registry.addViewController("/login").setViewName("admin/login");
    }

    @Autowired
    @Qualifier("RequestLogger")
    private HandlerInterceptor requestLogger;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.requestLogger);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/**");
//        registry.addResourceHandler("/img/**").addResourceLocations("/static/img/**");
//        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/**");
//        registry.addResourceHandler("/themes/**").addResourceLocations("/static/themes/**");
//        registry.addResourceHandler("/assets/**").addResourceLocations("/static/assets/**");
//        registry.addResourceHandler("/plugins/**").addResourceLocations("/static/plugins/**");
//    }
}