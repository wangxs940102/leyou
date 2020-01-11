package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.mybatis.spring.annotation.MapperScan;

@CrossOrigin(origins = "http://manage.leyou.com")
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.leyou.item.mapper")
public class ItemServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                ItemServerApplication.class
        );
    }
}
