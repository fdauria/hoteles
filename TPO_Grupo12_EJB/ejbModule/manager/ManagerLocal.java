package manager;

import java.util.List;

import javax.ejb.Local;

import model.HotelDTO;
import model.OfertaDTO;

@Local
public interface ManagerLocal {

	public List<HotelDTO> obtenerHoteles();

	public HotelDTO agregarHotel(HotelDTO hotel);

	public HotelDTO obtenerHotel(int id);
	
	public List<OfertaDTO> obtenerOfertas();

	public OfertaDTO agregarOferta(OfertaDTO oferta);

	public OfertaDTO obtenerOferta(int id);
}
