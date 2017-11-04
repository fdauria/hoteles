package manager;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import model.HotelDTO;
import model.OfertaDTO;

@Remote
public interface ManagerRemote {

	public List<HotelDTO> obtenerHoteles();

	public HotelDTO agregarHotel(HotelDTO hotel);

	public HotelDTO obtenerHotel(int id);
	
	public List<OfertaDTO> obtenerOfertas();

	public OfertaDTO agregarOferta(OfertaDTO oferta);

	public OfertaDTO obtenerOferta(int id);
}
