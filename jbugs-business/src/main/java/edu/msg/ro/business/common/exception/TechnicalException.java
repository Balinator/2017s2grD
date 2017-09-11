package edu.msg.ro.business.common.exception;

public class TechnicalException extends JBugsException {

	/**
	 * 
	 */

	private static final String MESSAGE_KEY = "exception.technical";

	private static final long serialVersionUID = 1L;

	public TechnicalException() {
		super(MESSAGE_KEY);
	}

	public TechnicalException(Throwable cause) {
		super(MESSAGE_KEY, cause);

	}
}
