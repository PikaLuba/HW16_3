package com.example.HW16_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo"
})
public class Hw163Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw163Application.class, args);
	}

}
