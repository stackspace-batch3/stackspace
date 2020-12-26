package org.stackspace.employee.exception;

public class FailedToSaveEmployeeException extends StackspaceException {

	public FailedToSaveEmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailedToSaveEmployeeException(String message) {
		super(message);
	}

	public FailedToSaveEmployeeException(Throwable cause) {
		super(cause);
	}

}
