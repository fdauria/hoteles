package interfaces;

import java.util.List;

import javax.ejb.Local;

import model.HotelDTO;

@Local
public interface IHotelDAO {

	public List<HotelDTO> obtenerHoteles();

	public HotelDTO agregarHotel(HotelDTO hotel);

	public HotelDTO obtenerHotel(int id);

}
