package com.comp586.bonfilms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class BonFilmsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonFilmsSpringBootApplication.class, args);
    }

}
