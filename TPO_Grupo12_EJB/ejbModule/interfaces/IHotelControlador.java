package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.HotelDTO;

@Remote
public interface IHotelControlador {

	public List<HotelDTO> obtenerHoteles();

	public HotelDTO agregarHotel(HotelDTO hotel);

	public HotelDTO obtenerHotel(int id);

	public String hello(String name);
}
