package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOClass implements DAOInterface {

	@PersistenceContext(unitName = "moduloHoteles")
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public <T> T saveEntity(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	public <T> T updateEntity(T entity) {
		em.merge(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> cls, String tabla) {
		try {
			List<T> list = em.createQuery("from " + tabla).getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}