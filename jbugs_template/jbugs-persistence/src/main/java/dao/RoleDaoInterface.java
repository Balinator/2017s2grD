package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Role;

@Remote
public interface RoleDaoInterface {
	public void persist(Role entity);

	public void delete(Role entity);

	public void update(Role entity);

	public Role find(int entityId);

	public List<Role> findAll();
}
