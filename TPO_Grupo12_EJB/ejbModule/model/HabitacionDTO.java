package model;

import java.io.Serializable;
import java.util.List;

public class HabitacionDTO  implements Serializable{

	private static final long serialVersionUID = 8523919109478097588L;
	
	private int habitacionId;
	private String descripcion;
	private int capacidad;
	private String tipo;
	private List<ServicioDTO> servicios;
	private HotelDTO hotel;

	public HabitacionDTO(int habitacionId, String descripcion, int capacidad, String tipo,
			List<ServicioDTO> servicios, HotelDTO hotelDTO) {
		super();
		this.habitacionId = habitacionId;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.setHotel(hotelDTO);
		this.servicios = servicios;
	}

	public int getHabitacionId() {
		return habitacionId;
	}

	public void setHabitacionId(int habitacionId) {
		this.habitacionId = habitacionId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<ServicioDTO> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

}
