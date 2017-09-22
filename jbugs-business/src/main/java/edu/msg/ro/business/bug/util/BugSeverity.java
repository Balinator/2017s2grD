package edu.msg.ro.business.bug.util;

/**
 * Enum for bug severity.
 * 
 * @author varadp
 *
 */
public enum BugSeverity {

	CRITICAL, HIGH, MEDIUM, LOW;

	public int key;

	/**
	 * Constructor.
	 */
	private BugSeverity() {
		this.key = ordinal();
	}

	/**
	 * Get bug severity by ID.
	 * 
	 * @param id
	 * @return BugSeverity
	 */
	public BugSeverity getSeverityById(int id) {
		return BugSeverity.values()[id];
	}
}
