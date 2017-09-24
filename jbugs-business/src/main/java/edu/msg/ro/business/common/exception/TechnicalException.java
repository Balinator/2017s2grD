package edu.msg.ro.business.common.exception;

/**
 * Exception class for technical problems.
 * 
 * @author laszll
 *
 */
public class TechnicalException extends JBugsException {

	private static final String MESSAGE_KEY = "exeption.technical";

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public TechnicalException() {
		super(MESSAGE_KEY);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 */
	public TechnicalException(Throwable cause) {
		super(MESSAGE_KEY, cause);
	}
}
