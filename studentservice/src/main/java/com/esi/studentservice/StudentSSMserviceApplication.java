package com.esi.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSSMserviceApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initialize("studentsssmservice_db");
		SpringApplication.run(StudentSSMserviceApplication.class, args);
	}
}
