package edu.msg.ro.business.common.exception;

public class TechnicalException extends JbugsException {

	private static final long serialVersionUID = -3287830846718786860L;
	private static final String message = "Unexpected error ocurred!";

	public TechnicalException(Throwable cause) {
		super(cause, message);
	}

	public TechnicalException() {
		super(message);
	}

}
