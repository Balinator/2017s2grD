package edu.msg.ro.business.common.exception;

public class JBugsExeption extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public JBugsExeption(String message) {
		super();
		this.message = message;
	}

	public JBugsExeption(String message, Throwable cause) {
		super(cause);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
