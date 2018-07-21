package com.verification.enums;

/**
 * The Enum ResponseMessage to show various response messages.
 * 
 * @author zeeshan
 */
public enum ResponseMessage {

	/** The success. */
	SUCCESS("successfull"),
	
	/** The error. */
	ERROR("error");

	/** The code. */
	private String message;

	/**
	 * Instantiates a new response message.
	 *
	 * @param message the message
	 */
	ResponseMessage(String message) {
		this.message = message;
	}

	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
