package dao;

import java.util.List;

import entities.Hotel;
import model.HotelDTO;

public class HotelDAO {

	public static HotelDAO instancia = null;

	public static HotelDAO getInstancia() {
		if (instancia == null)
			instancia = new HotelDAO();

		return instancia;
	}

	public void HotelesDAO() {

	}

	public List<Hotel> getHoteles() {
		return null;
	}

	public Hotel agregarHotel(HotelDTO hotelDto) {
		return null;
	}

}
