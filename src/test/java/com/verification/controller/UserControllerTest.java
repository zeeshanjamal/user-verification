/*
 * 
 */
package com.verification.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@Value("${local.server.port}")
	private int localServerPort;

	@Autowired
	private TestRestTemplate template;

	

	/**
	 * Should successfully get response when user id and code is provided for validation.
	 */
	@Test
	public void shouldSuccessfullyGetResponseWhenUserIdAndCodeIsProvidedForValidation() {
        ResponseEntity<Object> response = template.getForEntity("/verification-code/9b/a1", Object.class);
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode() );
	}
	
	/**
	 * Should successfully get response when user id is provided to generate code.
	 */
	@Test
	public void shouldSuccessfullyGetResponseWhenUserIdIsProvidedToGenerateCode() {
        ResponseEntity<Object> response = template.postForEntity("/verification-code/9b", null, Object.class);
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode() );
	}


}
