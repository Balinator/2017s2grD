package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.Permission;

@Remote
public interface PermissionDaoInterface {
	public void persist(Permission entity);

	public void delete(Permission entity);

	public void update(Permission entity);

	public Permission find(int entityId);

	public List<Permission> findAll();
}
