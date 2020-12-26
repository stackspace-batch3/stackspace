package org.stackspace.employee.exception;

public class StackspaceException extends Exception {

	public StackspaceException(String message, Throwable cause) {
		super(message, cause);
	}

	public StackspaceException(String message) {
		super(message);
	}

	public StackspaceException(Throwable cause) {
		super(cause);
	}

	public StackspaceException() {
		super();
	}
	

}
