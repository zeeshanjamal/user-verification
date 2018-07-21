package com.verification.dao;

/**
 * The contract UserDAO that holds the method definitions for saving and getting user codes.
 * 
 * @author zeeshan
 */
public interface UserDAO {

	
	/**
	 * Save code.
	 *
	 * @param userId the user id
	 * @param code the code
	 */
	public void saveCode(String userId, String code);
	
	/**
	 * Gets the code.
	 *
	 * @param userId the user id
	 * @return the code
	 */
	public String getCode(String userId);
}
