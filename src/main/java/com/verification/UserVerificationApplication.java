package com.verification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class UserVerificationApplication. The starting point of user-verification app.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class UserVerificationApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserVerificationApplication.class, args);
	}
}
