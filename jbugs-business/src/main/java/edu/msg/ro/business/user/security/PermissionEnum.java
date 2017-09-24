package edu.msg.ro.business.user.security;

import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

/**
 * {@link Role}s for {@link User}s
 * 
 * @author nemeta
 *
 */
public enum PermissionEnum {
	PERMISSION_MANAGEMENT(1L), USER_MANAGEMENT(2L), BUG_MANAGEMENT(3L), BUG_CLOSE(4L);

	private Long id;

	PermissionEnum(Long l) {
		this.id = l;
	}

	public Long getId() {
		return id;
	}

}
