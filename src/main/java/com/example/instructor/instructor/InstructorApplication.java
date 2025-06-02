package com.example.instructor.instructor;

import com.example.instructor.instructor.DAO.InstructorDaoImp;
import com.example.instructor.instructor.Entities.Instructor;
import com.example.instructor.instructor.Entities.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InstructorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstructorApplication.class, args);
	}

}
