package edu.msg.ro.business.status;

import java.util.Vector;

/**
 * Enum for bug status
 * 
 * @author fulops
 *
 */

public enum StatusEnum {
	/**
	 * The bug possible statuses.
	 */
	OPEN("open"), REJECTED("rejected"), INPROGRESS("inprogress"), INFONEEDED("infoneeded"), FIXED("fixed"), CLOSE("close");

	/**
	 * Every state every state has next state.
	 */
	static {
		OPEN.neighbors = new Vector<>();
		OPEN.neighbors.add(REJECTED);
		OPEN.neighbors.add(INPROGRESS);

		REJECTED.neighbors = new Vector<>();
		REJECTED.neighbors.add(CLOSE);

		INPROGRESS.neighbors = new Vector<>();
		INPROGRESS.neighbors.add(REJECTED);
		INPROGRESS.neighbors.add(INFONEEDED);
		INPROGRESS.neighbors.add(CLOSE);

		INFONEEDED.neighbors = new Vector<>();
		INFONEEDED.neighbors.add(INPROGRESS);

		FIXED.neighbors = new Vector<>();
		FIXED.neighbors.add(OPEN);
		FIXED.neighbors.add(CLOSE);

		CLOSE.neighbors = new Vector<>();

	}

	/**
	 * Constructor.
	 * 
	 * @param s
	 */
	StatusEnum(String s) {
		key = s;
	}

	public String key;
	public Vector<StatusEnum> neighbors;

}
