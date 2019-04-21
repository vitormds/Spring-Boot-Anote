package com.anote;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anote.repository.DbSeeder;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DbSeeder dbseeder; 
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		dbseeder.instatiateTestDatabase();	
	return true;
		
	}

}