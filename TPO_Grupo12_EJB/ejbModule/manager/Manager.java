package manager;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Hotel;
import entities.Oferta;
import model.HotelDTO;
import model.OfertaDTO;

@Stateless
public class Manager implements ManagerLocal {

	@PersistenceContext(unitName = "hoteles")
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
	
	public Manager() {
	}

	@Override
	public List<HotelDTO> obtenerHoteles() {
		return getAll(Hotel.class, "Hotel").stream().map(x -> x.toDTO()).collect(Collectors.toList());
	}

	//to do hacer esto
	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {		
		return saveEntity(hotel);
	}

	@Override
	public HotelDTO obtenerHotel(int id) {
		return ((Hotel) getEntityManager().createQuery("from Hotel where id=" + id).getSingleResult()).toDTO();
	}

	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return getAll(Oferta.class, "Oferta").stream().map(x -> x.toDTO()).collect(Collectors.toList());
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO oferta) {
		return saveEntity(oferta);

	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return ((Oferta) getEntityManager().createQuery("from Oferta where id=" + id).getSingleResult()).toDTO();
	}

	
}
