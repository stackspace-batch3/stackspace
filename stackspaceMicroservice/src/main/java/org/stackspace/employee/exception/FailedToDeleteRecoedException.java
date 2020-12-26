package org.stackspace.employee.exception;

public class FailedToDeleteRecoedException extends StackspaceException {

	public FailedToDeleteRecoedException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailedToDeleteRecoedException(String message) {
		super(message);
	}

	public FailedToDeleteRecoedException(Throwable cause) {
		super(cause);
	}

}
