package edu.msg.ro.business.bug.enums;

public enum BugRelationEnum {
	NONE(0), DUPLICATE(1), DIRECT_LINK(2), INTERDEPENDENCE(3), BLOCK(4);

	private BugRelationEnum(int key) {
		this.key = key;
	}

	private int key;

	public int getKey() {
		return key;
	}
}
