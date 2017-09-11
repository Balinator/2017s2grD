package edu.msg.ro.business.common.exception;

public class TechnicalExeption extends JBugsException {

	private static final String MESSAGE_KEY = "exeption.technical";

	private static final long serialVersionUID = 1L;

	public TechnicalExeption() {
		super(MESSAGE_KEY);
	}

	public TechnicalExeption(Throwable cause) {
		super(MESSAGE_KEY, cause);
	}
}
