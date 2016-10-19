package com.company.app.dao.exception;

public class AlreadyExistingMemberException extends RuntimeException{

	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
