package org.example.junit.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import tk.mybatis.spring.annotation.MapperScan;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@MapperScan(basePackages = {"org.example.dal.mapper"})
@ComponentScan(basePackages = {"org.example"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
public class JunitApplication  {

    public static void main(String[] args) throws Exception {
        try {
            SpringApplication.run(JunitApplication.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
