package com.jayden.admin;

import com.jayden.admin.model.AccountDto;
import com.jayden.admin.service.account.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class AdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Bean
    public CommandLineRunner initAccountData(AccountService accountService) {
        return (args) -> {
            accountService.create(AccountDto.CreateRequest.of("admin", "!@#", "ADMIN"));
        };
    }

}
