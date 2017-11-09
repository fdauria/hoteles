package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import controlador.ControladorRemote;
import model.HabitacionDTO;
import model.HotelDTO;
import model.MedioDePagoDTO;
import model.OfertaDTO;
import model.ServicioDTO;

public class ControladorBS implements ControladorRemote {

	private static ControladorBS instancia;

	@EJB
	private ControladorRemote controlador;

	public static ControladorBS getInstancia() {
		if (instancia == null)
			instancia = new ControladorBS();
		return instancia;
	}

	public ControladorBS() {

		try {
			InitialContext initialContext = new InitialContext();
			controlador = (ControladorRemote) initialContext.lookup(
					"ejb:TPO_Grupo12_EAR/TPO_Grupo12_EJB/" + "" + "/Controlador!" + ControladorRemote.class.getName());
		} catch (NamingException ex) {
			ex.printStackTrace();
		}

	}

	public List<HotelDTO> obtenerHoteles() {
		return controlador.obtenerHoteles();
	}

	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {
		return controlador.agregarHotel(hotel);
	}

	@Override
	public HotelDTO obtenerHotel(int id) {
		return controlador.obtenerHotel(id);
	}

	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return controlador.obtenerOfertas();
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO oferta) {
		return controlador.agregarOferta(oferta);
	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return controlador.obtenerOferta(id);
	}

	@Override
	public List<HabitacionDTO> obtenerHabitaciones() {
		return controlador.obtenerHabitaciones();
	}

	@Override
	public HabitacionDTO obtenerHabitacion(int id) {
		return controlador.obtenerHabitacion(id);
	}

	@Override
	public HabitacionDTO agregarHabitacion(HotelDTO hotelDTO, HabitacionDTO habitacionDTO) {
		return controlador.agregarHabitacion(hotelDTO, habitacionDTO);
	}

	@Override
	public List<ServicioDTO> obtenerServiciosPorTipo(int tipo) {
		return controlador.obtenerServiciosPorTipo(tipo);
	}

	@Override
	public List<MedioDePagoDTO> obtenerMediosDePago() {
		return controlador.obtenerMediosDePago();
	}

	@Override
	public void cargarServicios() {
		controlador.cargarServicios();
	}

	@Override
	public void cargarMediosDePago() {
		controlador.cargarMediosDePago();
	}

}