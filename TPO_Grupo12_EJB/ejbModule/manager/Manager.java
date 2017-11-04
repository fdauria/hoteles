package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Direccion;
import entities.Hotel;
import entities.MedioDePago;
import entities.Oferta;
import entities.Servicio;
import model.HotelDTO;
import model.MedioDePagoDTO;
import model.OfertaDTO;
import model.ServicioDTO;

@Stateless
public class Manager implements ManagerRemote {

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

	@Override
	public HotelDTO agregarHotel(HotelDTO hotelDTO) {
		Hotel hotel = new Hotel();
		hotel.setImagen(hotelDTO.getImagen());
		hotel.setNombre(hotelDTO.getNombre());
		
		if(hotelDTO.getDireccion() != null){
			Direccion direccion = new Direccion();
			direccion.setDireccion(hotelDTO.getDireccion().getDireccion());
			direccion.setLatitud(hotelDTO.getDireccion().getLatitud());
			direccion.setLongitud(hotelDTO.getDireccion().getLongitud());
			hotel.setDireccion(direccion);
		}
		
		final List<Servicio> servicios = new ArrayList<>();
		for(final ServicioDTO servicioDTO : hotelDTO.getServicios())
			servicios.add(new Servicio(servicioDTO.getServicioId(), servicioDTO.getDescripcion()));
		
		if(!servicios.isEmpty())
			hotel.setServicios(servicios);
		
		final List<MedioDePago> medioDePagoList = new ArrayList<>();
		for(final MedioDePagoDTO medioDePagoDTO : hotelDTO.getMediosDePago())
			medioDePagoList.add(new MedioDePago(medioDePagoDTO.getMedioDePagoId(), medioDePagoDTO.getDescripcion()));
		
		if(!medioDePagoList.isEmpty())
			hotel.setMediosDePago(medioDePagoList);	
		
		return saveEntity(hotel).toDTO();
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
