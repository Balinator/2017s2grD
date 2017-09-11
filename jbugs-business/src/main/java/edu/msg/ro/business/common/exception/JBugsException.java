package edu.msg.ro.business.common.exception;

public class JBugsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4798442134382306969L;
	private String message;

	public JBugsException(String message) {
		super();
		this.message = message;
	}

	public JBugsException(String message, Throwable cause) {
		super(cause);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
