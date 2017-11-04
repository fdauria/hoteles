package controllers;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import controlador.ControladorRemote;
import model.HotelDTO;

public class HotelControladorBS {

	private static HotelControladorBS instancia;

	@EJB
	private ControladorRemote controlador;

	public static HotelControladorBS getInstancia() {
		if (instancia == null)
			instancia = new HotelControladorBS();
		return instancia;
	}

	public HotelControladorBS() {

		try {
			InitialContext initialContext = new InitialContext();
			controlador = (ControladorRemote) initialContext.lookup(
					"ejb:TPO_Grupo12_EAR/TPO_Grupo12_EJB/" + "" + "/Controlador!" + ControladorRemote.class.getName());
		} catch (NamingException ex) {
			ex.printStackTrace();
		}

	}

	public void crearHotel(HotelDTO hotelDTO) {
		controlador.agregarHotel(hotelDTO);
	}

}