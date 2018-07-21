package com.verification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verification.model.VerificationDTO;
import com.verification.service.UserService;

/**
 * The Class UserController holds the end points for user verification.
 * 
 * @author zeeshan
 */
@RestController
@RequestMapping("/verification-code")
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Save user code.
	 *
	 * @param userId
	 *            the user id
	 * @return the response entity
	 */
	@PostMapping("/{user_id}")
	public ResponseEntity<VerificationDTO> saveUserCode(@PathVariable("user_id") String userId) {
		return new ResponseEntity<>(userService.generateCode(userId), HttpStatus.OK);
	}

	/**
	 * Validate user code.
	 *
	 * @param userId
	 *            the user id
	 * @param code
	 *            the code
	 * @return the response entity
	 */
	@GetMapping("/{user_id}/{code}")
	public ResponseEntity<VerificationDTO> validateUserCode(@PathVariable("user_id") String userId,
			@PathVariable("code") String code) {
		return new ResponseEntity<>(userService.validateCode(userId, code), HttpStatus.OK);
	}

	/**
	 * Sets the user service.
	 *
	 * @param userService
	 *            the new user service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
