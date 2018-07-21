package com.verification.service.impl;


import org.easymock.EasyMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.verification.dao.UserDAO;
import com.verification.enums.ResponseMessage;
import com.verification.enums.ResultCode;
import com.verification.model.VerificationDTO;

import org.junit.Assert;

/**
 * The Class UserServiceImplTest used to test {@link UserServiceImpl}.
 * 
 * @author zeeshan
 */
public class UserServiceImplTest {

	/** The user service impl. */
	private UserServiceImpl userServiceImpl;
	
	/** The user DAO. */
	private UserDAO userDAO;
	
	/** The Constant VALID_USER_ID. */
	private static final String VALID_USER_ID = "user12";
	
	/** The Constant INVALID_USER_ID. */
	private static final String INVALID_USER_ID = ",x ";
	
	/** The Constant VALID_CODE. */
	private static final String VALID_CODE = "testValidCode";
	
	/** The Constant INVALID_CODE. */
	private static final String INVALID_CODE = "testInValidCode,";
	
	/**
	 * Sets the up.
	 */
	@Before
	public void setUp(){
		userServiceImpl = new UserServiceImpl();
		userDAO = createNiceMock(UserDAO.class);
		userServiceImpl.setUserDAO(userDAO);
	}
	
	
	/**
	 * Should successfully generate user code when valid user id is provided.
	 */
	@Test
	public void shouldSuccessfullyGenerateUserCodeWhenValidUserIdIsProvided(){
		VerificationDTO expected = prepareVerificationDTO(ResultCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage());
		VerificationDTO actual = userServiceImpl.generateCode(VALID_USER_ID);
		Assert.assertEquals(expected, actual);
	}
	
	
	/**
	 * Should not successfully generate user code when invalid user is provided.
	 */
	@Test
	public void shouldNotSuccessfullyGenerateUserCodeWhenInvalidUserIsProvided(){
		VerificationDTO expected = prepareVerificationDTO(ResultCode.ERROR.getCode(), ResponseMessage.ERROR.getMessage());
		VerificationDTO actual = userServiceImpl.generateCode(INVALID_USER_ID);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Should successfully validate user code when valid user id and code is provided.
	 */
	@Test
	public void shouldSuccessfullyValidateUserCodeWhenValidUserIdAndCodeIsProvided(){
		VerificationDTO expected = prepareVerificationDTO(ResultCode.SUCCESS.getCode(), true);
		expect(userDAO.getCode(EasyMock.anyString())).andReturn(VALID_CODE);
		replay(userDAO);
		VerificationDTO actual = userServiceImpl.validateCode(VALID_USER_ID, VALID_CODE);
		Assert.assertEquals(expected, actual);
	}
	
	
	
	/**
	 * Should not successfully validate user code when in valid code is provided.
	 */
	@Test
	public void shouldNotSuccessfullyValidateUserCodeWhenInValidCodeIsProvided(){
		VerificationDTO expected = prepareVerificationDTO(ResultCode.SUCCESS.getCode(), false);
		expect(userDAO.getCode(EasyMock.anyString())).andReturn(INVALID_CODE);
		replay(userDAO);
		VerificationDTO actual = userServiceImpl.validateCode(VALID_USER_ID, StringUtils.EMPTY);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Should not successfully validate user code when in valid user id is provided.
	 */
	@Test
	public void shouldNotSuccessfullyValidateUserCodeWhenInValidUserIdIsProvided(){
		VerificationDTO expected = prepareVerificationDTO(ResultCode.ERROR.getCode(), true);
		VerificationDTO actual = userServiceImpl.validateCode(INVALID_USER_ID, StringUtils.EMPTY);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Prepare verification DTO.
	 *
	 * @param resultCode the result code
	 * @param message the message
	 * @return the verification DTO
	 */
	private VerificationDTO prepareVerificationDTO(int resultCode, String message){
		return new VerificationDTO(resultCode, message);
	}
	
	/**
	 * Prepare verification DTO.
	 *
	 * @param resultCode the result code
	 * @param valid the valid
	 * @return the verification DTO
	 */
	private VerificationDTO prepareVerificationDTO(int resultCode, boolean valid){
		return new VerificationDTO(resultCode, valid);
	}
}
