package dao.old;

public class Dao {
	private PermissionDao permissionDao;
	private RoleDao roleDao;
	private UserDao userDao;

	public Dao() {
		super();
	}

	public PermissionDao getPermissionDao() {
		if (permissionDao == null) {
			permissionDao = new PermissionDao();
		}
		return permissionDao;
	}

	public RoleDao getRoleDao() {
		if (roleDao == null) {
			roleDao = new RoleDao();
		}
		return roleDao;
	}

	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}
}
