package com.qiaolu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TliasAiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasAiProjectApplication.class, args);
    }

}
