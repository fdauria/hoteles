package hibernate;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAOInterface {
	public EntityManager getEntityManager();

	public <T> T saveEntity(T entity);

	public <T> T updateEntity(T entity);

	public <T> List<T> getAll(Class<T> cls, String tabla);
}