package com.example.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义拦截器
 * @author yuanjie
 * @date 2018/9/27 11:44
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器, 连接以/test 为前缀的url路径
        registry.addInterceptor(new AdminLoginIntecept()).addPathPatterns("/test/**");
    }

//    public void addCorsMapping(CorsRegistry corsRegistry) {
////        corsRegistry.addMapping("/**")
////                .allowCredentials(true)
////                .allowedHeaders("*")
////                .allowedOrigins("*")
////                .allowedMethods("*");
////    }
}
