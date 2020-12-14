package com.java_avancer.java_avancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JavaAvancerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaAvancerApplication.class, args);
    }

}
