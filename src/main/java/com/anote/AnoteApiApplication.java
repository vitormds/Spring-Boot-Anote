package com.anote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anote.repository.DbSeeder;

@SpringBootApplication
public class AnoteApiApplication implements CommandLineRunner {
	@Autowired DbSeeder dbSeeder;
    public static void main(String[] args) {
        SpringApplication.run(AnoteApiApplication.class, args);
    }
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
