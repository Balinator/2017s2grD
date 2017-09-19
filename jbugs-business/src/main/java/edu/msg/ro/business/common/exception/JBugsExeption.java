package edu.msg.ro.business.common.exception;

/**
 * Exception class for JBugs applications exceptions.
 * 
 * @author laszll
 *
 */
public class JBugsExeption extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	/**
	 * Constructor.
	 * 
	 * @param message
	 */
	public JBugsExeption(String message) {
		super();
		this.message = message;
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 * @param cause
	 */
	public JBugsExeption(String message, Throwable cause) {
		super(cause);
		this.message = message;
	}

	/**
	 * Method for getting the message.
	 */
	@Override
	public String getMessage() {
		return message;
	}

}
