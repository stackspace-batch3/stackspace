package org.stackspace.employee.exception;

public class FailedToGetEmployeeException extends StackspaceException {

	public FailedToGetEmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailedToGetEmployeeException(String message) {
		super(message);
	}

	public FailedToGetEmployeeException(Throwable cause) {
		super(cause);
	}

}
