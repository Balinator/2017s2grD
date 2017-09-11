package edu.msg.ro.business.common.exception;

public class JbugsException extends Exception {

	private static final long serialVersionUID = -3668181739152626205L;
	private String message;

	public JbugsException(String message) {
		super();
		this.message = message;
	}

	public JbugsException(Throwable cause, String message) {
		super(cause);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
