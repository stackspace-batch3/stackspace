package org.stackspace.employee.exception;

public class RecordNotFoundException extends StackspaceException {

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(Throwable cause) {
		super(cause);
	}

	public RecordNotFoundException() {
		super();
	}

	

}
