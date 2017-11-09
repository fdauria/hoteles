package manager;

import java.util.List;

import javax.ejb.Remote;

import model.HabitacionDTO;
import model.HotelDTO;
import model.MedioDePagoDTO;
import model.OfertaDTO;
import model.ServicioDTO;

@Remote
public interface ManagerRemote {

	public List<HotelDTO> obtenerHoteles();

	public HotelDTO agregarHotel(HotelDTO hotel);
	
	public HotelDTO actualizarConIdBackoffice(HotelDTO hotelDTO);

	public HotelDTO obtenerHotel(int id);
	
	public List<OfertaDTO> obtenerOfertas();

	public OfertaDTO agregarOferta(OfertaDTO oferta);

	public OfertaDTO obtenerOferta(int id);
	
	public List<HabitacionDTO> obtenerHabitaciones();
	
	public HabitacionDTO obtenerHabitacion(int id);
	
	public HabitacionDTO agregarHabitacion(HabitacionDTO habitacion);
	
	public List<ServicioDTO> obtenerServiciosPorTipo(int tipo);
	
	public List<MedioDePagoDTO> obtenerMediosDePago();

	public void cargarServicios();
	
	public void cargarMediosDePago();


}
