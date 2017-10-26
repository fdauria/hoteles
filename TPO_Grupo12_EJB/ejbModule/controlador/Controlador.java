package controlador;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hibernate.HibernateDAOLocal;
import model.HotelDTO;
import model.OfertaDTO;

@Stateless
public class Controlador implements ControladorRemote {

	@EJB
	private HibernateDAOLocal interfaceLocal;

	public Controlador() {
	}
	
	@Override
	public List<HotelDTO> obtenerHoteles() {
		return interfaceLocal.obtenerHoteles();
	}

	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {
		return interfaceLocal.agregarHotel(hotel);
	}

	@Override
	public HotelDTO obtenerHotel(int id) {
		return interfaceLocal.obtenerHotel(id);
	}

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
	
	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return interfaceLocal.obtenerOfertas();
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO oferta) {
		return interfaceLocal.agregarOferta(oferta);
	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return interfaceLocal.obtenerOferta(id);
	}
}
