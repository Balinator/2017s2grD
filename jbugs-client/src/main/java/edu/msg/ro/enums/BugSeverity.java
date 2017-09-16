package edu.msg.ro.enums;

/**
 * enum for bug severity
 * 
 * @author varadp
 *
 */
public enum BugSeverity {

	CRITICAL(0), HIGH(1), MEDIUM(2), LOW(3);

	private final int label;

	private BugSeverity(int label) {
		this.label = label;
	}

	public int getLabel() {
		return label;
	}
}
