package controlador;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import interfaces.IHotelControlador;
import interfaces.IHotelDAO;
import model.HotelDTO;

@Stateless
public class HotelControlador implements IHotelControlador {

	@EJB
	private IHotelDAO iHotelDAO;

	public HotelControlador() {

	}

	@Override
	public List<HotelDTO> obtenerHoteles() {
		return iHotelDAO.obtenerHoteles();
	}

	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {
		return iHotelDAO.agregarHotel(hotel);
	}

	@Override
	public HotelDTO obtenerHotel(int id) {
		return iHotelDAO.obtenerHotel(id);
	}

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
}
