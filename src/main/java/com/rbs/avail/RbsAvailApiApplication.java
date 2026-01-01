package com.rbs.avail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RbsAvailApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RbsAvailApiApplication.class, args);
    }
}
