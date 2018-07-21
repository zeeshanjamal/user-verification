package com.verification.enums;

/**
 * The Enum ResultCode to show various response codes.
 * 
 * @author zeeshan
 */
public enum ResultCode {

	/** The success. */
	SUCCESS(1),
	
	/** The error. */
	ERROR(0);

	/** The code. */
	private int code;

	/**
	 * Instantiates a new result code.
	 *
	 * @param code the code
	 */
	ResultCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

}
