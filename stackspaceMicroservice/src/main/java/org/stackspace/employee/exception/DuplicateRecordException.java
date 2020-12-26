package org.stackspace.employee.exception;

public class DuplicateRecordException extends StackspaceException {

	public DuplicateRecordException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateRecordException(String message) {
		super(message);
	}

	public DuplicateRecordException(Throwable cause) {
		super(cause);
	}

}
