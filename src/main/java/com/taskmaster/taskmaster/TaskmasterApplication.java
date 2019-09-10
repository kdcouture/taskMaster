package com.taskmaster.taskmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class TaskmasterApplication {

	@Value("${amazon.aws.accesskey}")
	private static String amazonAWSAccessKey;

	public static void main(String[] args) {
		SpringApplication.run(TaskmasterApplication.class, args);
	}

}
