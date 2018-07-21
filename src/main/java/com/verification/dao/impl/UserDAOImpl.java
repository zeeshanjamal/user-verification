/*
 * 
 */
package com.verification.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.verification.dao.UserDAO;

/**
 * The implementation class of UserDAO to save and get user codes from memory.
 * 
 * @author zeeshan
 */
@Service
public class UserDAOImpl implements UserDAO {

	/** The user codes map. */
	private Map<String, String> userCodes = new HashMap<>();

	/**
	 * Save code.
	 *
	 * @param userId
	 *            the user id
	 * @param code
	 *            the code
	 */
	@Override
	public void saveCode(String userId, String code) {
		userCodes.put(userId, code);

	}

	/**
	 * Gets the code.
	 *
	 * @param userId
	 *            the user id
	 * @return the code
	 */
	@Override
	public String getCode(String userId) {
		return userCodes.get(userId);
	}

}
