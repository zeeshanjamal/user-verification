package com.verification.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class VerificationDTO that is sent as response for various function of user verification.
 * 
 * @author zeeshan
 */
@JsonInclude(Include.NON_NULL)
public class VerificationDTO {

	/** The result code. */
	@JsonProperty(value = "result_code")
	private int resultCode;

	/** The message. */
	private String message;

	/** The valid. */
	private Boolean valid;

	/**
	 * Instantiates a new response DTO.
	 *
	 * @param resultCode
	 *            the result code
	 * @param message
	 *            the message
	 * @param valid
	 *            the valid
	 */
	public VerificationDTO(int resultCode, String message, boolean valid) {
		this.resultCode = resultCode;
		this.message = message;
		this.valid = valid;
	}

	/**
	 * Instantiates a new response DTO.
	 *
	 * @param resultCode
	 *            the result code
	 * @param valid
	 *            the valid
	 */
	public VerificationDTO(int resultCode, boolean valid) {
		this.resultCode = resultCode;
		this.valid = valid;
	}

	/**
	 * Instantiates a new response DTO.
	 *
	 * @param resultCode
	 *            the result code
	 * @param message
	 *            the message
	 */
	public VerificationDTO(int resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}

	/**
	 * Gets the result code.
	 *
	 * @return the result code
	 */
	public int getResultCode() {
		return resultCode;
	}

	/**
	 * Sets the result code.
	 *
	 * @param resultCode
	 *            the new result code
	 */
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	public Boolean isValid() {
		return valid;
	}

	/**
	 * Sets the valid.
	 *
	 * @param valid
	 *            the new valid
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + resultCode;
		result = 31 * result + message.hashCode();
		result = 31 * result + valid.hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof VerificationDTO)) {
			return false;
		}
		VerificationDTO verificationDTO = (VerificationDTO) o;
		return resultCode == verificationDTO.resultCode && Objects.equals(message, verificationDTO.message)
				&& Objects.equals(valid, verificationDTO.valid);
	}
}
