package com.cscd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com"}
)
public class CscdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CscdApplication.class, args);
    }

}
