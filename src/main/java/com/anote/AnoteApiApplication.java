package com.anote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.anote.repository.DbSeeder;

@SpringBootApplication
public class AnoteApiApplication extends SpringBootServletInitializer {
	@Autowired DbSeeder dbSeeder;
    public static void main(String[] args) {
        SpringApplication.run(AnoteApiApplication.class, args);
    }

}
