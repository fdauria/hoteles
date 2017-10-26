package hibernate;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import entities.Hotel;
import entities.Oferta;
import model.HotelDTO;
import model.OfertaDTO;

@Stateless
public class HibernateDAO extends DAOClass implements HibernateDAOLocal {

	public HibernateDAO() {
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
