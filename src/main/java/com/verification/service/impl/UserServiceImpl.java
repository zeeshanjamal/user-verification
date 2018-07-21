package com.verification.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verification.dao.UserDAO;
import com.verification.enums.ResponseMessage;
import com.verification.enums.ResultCode;
import com.verification.model.VerificationDTO;
import com.verification.service.UserService;

/**
 * The implementation class of user service to generate and validate user code.
 * 
 * @author zeeshan
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verification.service.UserService#generateCode(java.lang.String)
	 */
	@Override
	public VerificationDTO generateCode(String userId) {
		String code = RandomStringUtils.randomAlphanumeric(6);
		if (StringUtils.isAlphanumeric(userId)) {
			userDAO.saveCode(userId, code);
			return prepareVerificationDTO(ResultCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage());
		}
		return prepareVerificationDTO(ResultCode.ERROR.getCode(), ResponseMessage.ERROR.getMessage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verification.service.UserService#validateCode(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public VerificationDTO validateCode(String userId, String code) {
		VerificationDTO verificationDTOtoReturn = null;
		if (!StringUtils.isAlphanumeric(userId)) {
			return prepareVerificationDTO(ResultCode.ERROR.getCode(), true);
		}
		if (code.equals(userDAO.getCode(userId))) {
			verificationDTOtoReturn = prepareVerificationDTO(ResultCode.SUCCESS.getCode(), true);
		} else {
			verificationDTOtoReturn = prepareVerificationDTO(ResultCode.SUCCESS.getCode(), false);
		}
		return verificationDTOtoReturn;
	}

	/**
	 * Prepare verification DTO.
	 *
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @return the verification DTO
	 */
	private VerificationDTO prepareVerificationDTO(int code, String message) {
		return new VerificationDTO(code, message);
	}

	/**
	 * Prepare verification DTO.
	 *
	 * @param code
	 *            the code
	 * @param valid
	 *            the valid
	 * @return the verification DTO
	 */
	private VerificationDTO prepareVerificationDTO(int code, boolean valid) {
		return new VerificationDTO(code, valid);
	}

	/**
	 * Sets the user DAO.
	 *
	 * @param userDAO
	 *            the new user DAO
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
