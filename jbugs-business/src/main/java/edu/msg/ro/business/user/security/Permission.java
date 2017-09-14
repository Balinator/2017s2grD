package edu.msg.ro.business.user.security;

/**
 * Permissions for users
 * 
 * @author nemeta
 *
 */
public enum Permission {
	PM("permission.management"), UM("user.management"), BM("bug.management"), BC("bug.close");

	private String name;

	Permission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
