package entities;

import java.util.List;

public class Hotel {

	private int hotelId;
	private String nombre;
	private Direccion direccion;
	private List<Imagen> imagenes;
	private List<Servicio> servicios;
	private List<Habitacion> habitaciones;
	private List<MedioDePago> mediosDePago;

	public Hotel(int hotelId, String nombre, Direccion direccion, List<Imagen> imagenes, List<Servicio> servicios,
			List<Habitacion> habitaciones, List<MedioDePago> mediosDePago) {
		super();
		this.hotelId = hotelId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.imagenes = imagenes;
		this.servicios = servicios;
		this.habitaciones = habitaciones;
		this.mediosDePago = mediosDePago;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<MedioDePago> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(List<MedioDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

}
