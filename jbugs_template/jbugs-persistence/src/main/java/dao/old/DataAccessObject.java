package dao.old;

import java.util.List;

//@Remote
public interface DataAccessObject<T> {
	public void persist(T entity);

	public void delete(T entity);

	public void update(T entity);

	public T find(int entityId);

	public List<T> findAll();
}
