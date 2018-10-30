package com.example.manager.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 设置类型转换器，将String类型日期进行转换成Date
 */
@Component
public class DateConverter implements Converter<String, Date> {
    // 重写方法，进行数据类型转换
    @Override
    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(s);
            return date;
        } catch (Exception e) {
            System.out.println("格式化日期失败");
        }
        return null;
    }
}
