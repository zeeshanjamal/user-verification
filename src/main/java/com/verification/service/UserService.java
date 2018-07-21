package com.verification.service;

import com.verification.model.VerificationDTO;

/**
 * The Interface contract that contain methods for generating and validating user codes.
 * 
 * @author zeeshan
 */
public interface UserService {


	/**
	 * Generate code.
	 *
	 * @param userId the user id
	 * @return the verification DTO
	 */
	public VerificationDTO generateCode(String userId);

	/**
	 * Validate code.
	 *
	 * @param userId the user id
	 * @param code the code
	 * @return the verification DTO
	 */
	public VerificationDTO validateCode(String userId, String code);
}
