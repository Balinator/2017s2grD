package dao;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserDaoInterface {
	public void persist(User entity);

	public void delete(User entity);

	public void update(User entity);

	public User find(int entityId);

	public List<User> findAll();
}
