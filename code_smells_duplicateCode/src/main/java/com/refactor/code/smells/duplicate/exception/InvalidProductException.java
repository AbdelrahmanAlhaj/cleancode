package com.refactor.code.smells.duplicate.exception;

import com.refactor.code.smells.duplicate.model.ErrorType;

public class InvalidProductException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7151653465797683900L;

	public InvalidProductException() {
	}

	public InvalidProductException(String message, Integer code) {
		super(message, code);
	}

	public InvalidProductException(String message, Integer code, ErrorType errorType) {
		super(message, code, errorType);

	}

}
