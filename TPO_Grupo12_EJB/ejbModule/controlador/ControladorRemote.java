package controlador;

import java.util.List;

import javax.ejb.Remote;

import model.HotelDTO;
import model.OfertaDTO;

@Remote
public interface ControladorRemote {
	public List<HotelDTO> obtenerHoteles();

	public HotelDTO agregarHotel(HotelDTO hotel);

	public HotelDTO obtenerHotel(int id);

	public List<OfertaDTO> obtenerOfertas();

	public OfertaDTO agregarOferta(OfertaDTO oferta);

	public OfertaDTO obtenerOferta(int id);
	
	public String hello(String name);
}
