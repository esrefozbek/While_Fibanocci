package org.example.junit.base;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableFeignClients(basePackages = {"org.example"})
@SpringBootApplication
@ComponentScan(basePackages = {"org.example"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
public class FeignJunitApplication  {

    public static void main(String[] args) throws Exception {
        try {
            SpringApplication.run(FeignJunitApplication.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
