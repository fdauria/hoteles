package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Direccion;
import entities.Habitacion;
import entities.Hotel;
import entities.MedioDePago;
import entities.Oferta;
import entities.Servicio;
import model.HabitacionDTO;
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
		Hotel hotel = saveEntity(hotelFromDTO(hotelDTO));
		
		
		final List<Servicio> servicios = new ArrayList<>();
		for(final ServicioDTO servicioDTO : hotelDTO.getServicios())
			servicios.add(obtenerServicio(servicioDTO.getServicioId()));
		
		if(!servicios.isEmpty())
			hotel.setServicios(servicios);
		
		final List<MedioDePago> medioDePagoList = new ArrayList<>();
		for(final MedioDePagoDTO medioDePagoDTO : hotelDTO.getMediosDePago())
			medioDePagoList.add(obtenerMedioDePago(medioDePagoDTO.getMedioDePagoId()));
		
		if(!medioDePagoList.isEmpty())
			hotel.setMediosDePago(medioDePagoList);	
		
		return updateEntity(hotel).toDTO();
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO ofertaDTO) {
		Oferta oferta = saveEntity(ofertaFromDTO(ofertaDTO));

		oferta.setHotel(obtenerHotelEntity(ofertaDTO.getHotel().getHotelId()));
		oferta.setHabitacion(obtenerHabitacionEntity(ofertaDTO.getHabitacion().getHabitacionId()));
		return updateEntity(oferta).toDTO();
	}
	
	public HotelDTO actualizarConIdBackoffice(HotelDTO hotelDTO){
		return updateEntity(hotelFromDTO(hotelDTO)).toDTO();
	}
	
	@Override
	public HotelDTO obtenerHotel(int id) {
		return ((Hotel) getEntityManager().createQuery("from Hotel where hotelId=" + id).getSingleResult()).toDTO();
	}

	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return getAll(Oferta.class, "Oferta").stream().map(x -> x.toDTO()).collect(Collectors.toList());
	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return ((Oferta) getEntityManager().createQuery("from Oferta where ofertaId=" + id).getSingleResult()).toDTO();
	}
	
	@Override
	public List<HabitacionDTO> obtenerHabitaciones() {
		return getAll(Habitacion.class, "Habitacion").stream().map(x -> x.toDTO()).collect(Collectors.toList());
	}

	@Override
	public HabitacionDTO obtenerHabitacion(int id) {
		return ((Habitacion) getEntityManager().createQuery("from Habitacion where habitacionId=" + id).getSingleResult()).toDTO();
	}

	@Override
	public HabitacionDTO agregarHabitacion(HotelDTO hotelDTO, HabitacionDTO habitacionDTO) {
		final Hotel hotel = obtenerHotelEntity(hotelDTO.getHotelId());
		final Habitacion habitacion = habitacionFromDTO(habitacionDTO);
		hotel.getHabitaciones().add(habitacion);
		updateEntity(hotel);
		
		return habitacion.toDTO();
	}
	
	
	private Hotel obtenerHotelEntity(int id){
		return (Hotel) getEntityManager().createQuery("from Hotel where hotelId=" + id).getSingleResult();
	}
	
	private Habitacion obtenerHabitacionEntity(int id){
		return (Habitacion) getEntityManager().createQuery("from Habitacion where habitacionId=" + id).getSingleResult();
	}
	
	public Hotel hotelFromDTO(HotelDTO hotelDTO){
 		final Hotel hotel = new Hotel();
		hotel.setImagen(hotelDTO.getImagen());
		hotel.setNombre(hotelDTO.getNombre());
		
		if(hotelDTO.getHotelId() != 0){
			hotel.setHotelId(hotelDTO.getHotelId());
		}
		
		if(hotelDTO.getDireccion() != null){
			Direccion direccion = new Direccion();
			direccion.setDestino(hotelDTO.getDireccion().getDestino());
			direccion.setDireccion(hotelDTO.getDireccion().getDireccion());
			direccion.setLatitud(hotelDTO.getDireccion().getLatitud());
			direccion.setLongitud(hotelDTO.getDireccion().getLongitud());
			hotel.setDireccion(direccion);
		}
		
		hotel.setBackofficeId(hotelDTO.getBackofficeId());
		
		return hotel;
	}
	
	public Oferta ofertaFromDTO(OfertaDTO ofertaDTO){
		final Oferta oferta = new Oferta();
		oferta.setFechaDesde(ofertaDTO.getFechadDesde());
		oferta.setFechaHasta(ofertaDTO.getFechaHasta());
		oferta.setCupo(ofertaDTO.getCupo());
		oferta.setPrecio(ofertaDTO.getPrecio());
		oferta.setPoliticaCancelacion(ofertaDTO.getPoliticaCancelacion());
		
		return oferta;
	}
	
	public Habitacion habitacionFromDTO(HabitacionDTO habitacionDTO){
		final Habitacion habitacion = new Habitacion();
		habitacion.setCapacidad(habitacionDTO.getCapacidad());
		habitacion.setDescripcion(habitacionDTO.getDescripcion());
		habitacion.setTipo(habitacionDTO.getTipo());
		habitacion.setNombre(habitacionDTO.getNombre());
		habitacion.setImagen(habitacionDTO.getImagen());
		
		final List<Servicio> servicios = new ArrayList<>();
		for(final ServicioDTO servicioDTO : habitacionDTO.getServicios()){
			servicios.add(obtenerServicio(servicioDTO.getServicioId()));
		}
		
		if(!servicios.isEmpty())
			habitacion.setServicios(servicios);
				
		if(habitacionDTO.getHabitacionId() != 0) 
			habitacion.setHabitacionId(habitacionDTO.getHabitacionId());
		
		return habitacion;
	}
	
	private Servicio obtenerServicio(int id) {
		return ((Servicio) getEntityManager().createQuery("from Servicio where servicioId=" + id).getSingleResult());
	}
	
	private MedioDePago obtenerMedioDePago(int id) {
		return ((MedioDePago) getEntityManager().createQuery("from MedioDePago where medioDePagoId=" + id).getSingleResult());
	}
	
	public List<ServicioDTO> obtenerServiciosPorTipo(int tipo){
//		cargarServicios();
		return getAll(Servicio.class, "Servicio").stream().filter(servicio -> servicio.getTipo() == tipo).map(x -> x.toDTO()).collect(Collectors.toList());
	}

	@Override
	public List<MedioDePagoDTO> obtenerMediosDePago() {
		cargarMediosDePago();
		return getAll(MedioDePago.class, "MedioDePago").stream().map(x -> x.toDTO()).collect(Collectors.toList());
	}

	@Override
	public void cargarServicios() {
		updateEntity(new Servicio(1,1, "Estacionamiento"));
		updateEntity(new Servicio(2,1, "Wifi"));
		updateEntity(new Servicio(3,1, "Desayuno"));
		updateEntity(new Servicio(4,1, "Media pension"));
		updateEntity(new Servicio(5,1, "Picina"));
		updateEntity(new Servicio(6,1, "Cancha de golf"));

		updateEntity(new Servicio(7,2, "Televisor"));
		updateEntity(new Servicio(8,2, "Jacuzi"));
		updateEntity(new Servicio(9,2, "Aire acondicionado"));
		updateEntity(new Servicio(10,2, "Parrilla"));
		updateEntity(new Servicio(11,2, "Lavarropas"));
		updateEntity(new Servicio(12,2, "Microondas"));	
	}

	@Override
	public void cargarMediosDePago() {
		updateEntity(new MedioDePago(1, "Tarjeta de credito"));
		updateEntity(new MedioDePago(2, "Cheque"));
		updateEntity(new MedioDePago(3, "Pago en destino"));
		updateEntity(new MedioDePago(4, "Mercado Pago"));
		updateEntity(new MedioDePago(5, "Paypal"));
	}
	

	@Override
	public void cargarServiciosPorTipo(List<ServicioDTO> servicioDTOs) {
		for (ServicioDTO servicioDTO : servicioDTOs) {
			saveEntity(new Servicio(servicioDTO.getServicioId(),servicioDTO.getTipo(), servicioDTO.getDescripcion()));
		}
		
	}

}
