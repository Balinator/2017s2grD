package edu.msg.ro.business.status;

import java.util.Vector;

public enum StatusEnum {
	OPEN("open"), REJECTED("rejected"), INPROGRESS("inprogress"), INFONEEDED("infoneeded"), FIXED("fixed"), CLOSE(
			"close");

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

	StatusEnum(String s) {
		key = s;
	}

	public String key;
	public Vector<StatusEnum> neighbors;

}
