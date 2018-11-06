package com.example.manager.config;

import org.joda.time.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

/**
 * 将日定义的类型转换器进行注册配置
 */
//@Configuration
public class ConverterConfig implements WebMvcConfigurer {

    /**
     * 配置日期类型转换器
     * 方法类型必须为ConversionService，参数为自定义的转换器
     * 注解声明按照类型自动注入bean
     * @param dateConverter
     * @return
     */
    @Bean
    @Autowired
    public ConversionService getConversionService(DateConverter dateConverter) {
        // 创建转换器工厂
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        // 创建转换器集合，将转换器放入集合
        Set<Converter> converters = new HashSet<Converter>();
        converters.add((Converter) dateConverter);
        // 将转换器集合设置到工厂
        factoryBean.setConverters(converters);
        // 返回转换器服务
        return factoryBean.getObject();
    }
}
