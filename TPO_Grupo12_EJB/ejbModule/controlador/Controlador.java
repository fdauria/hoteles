package controlador;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import manager.ManagerRemote;
import model.HotelDTO;
import model.OfertaDTO;

@Stateless
public class Controlador implements ControladorRemote {

	@EJB
	private ManagerRemote inferfazRemota;

	public Controlador() {
	}
	
	@Override
	public List<HotelDTO> obtenerHoteles() {
		return inferfazRemota.obtenerHoteles();
	}

	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {
		return inferfazRemota.agregarHotel(hotel);
	}

	@Override
	public HotelDTO obtenerHotel(int id) {
		return inferfazRemota.obtenerHotel(id);
	}

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
	
	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return inferfazRemota.obtenerOfertas();
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO oferta) {
		return inferfazRemota.agregarOferta(oferta);
	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return inferfazRemota.obtenerOferta(id);
	}
}
