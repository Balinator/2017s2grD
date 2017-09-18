package edu.msg.ro.enums;

/**
 * Enum for bug severity.
 * 
 * @author varadp
 *
 */
public enum BugSeverity {

	CRITICAL(0), HIGH(1), MEDIUM(2), LOW(3);

	private final int label;

	/**
	 * Constructor.
	 * 
	 * @param label
	 */
	private BugSeverity(int label) {
		this.label = label;
	}

	/**
	 * Get for label.
	 * 
	 * @return
	 */
	public int getLabel() {
		return label;
	}
}
