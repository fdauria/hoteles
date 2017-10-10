package model;

import java.util.List;

public class HotelDTO {

	private int hotelId;
	private String nombre;
	private DireccionDTO direccion;
	private List<ImagenDTO> imagenes;
	private List<ServicioDTO> servicios;
	private List<HabitacionDTO> habitaciones;
	private List<MedioDePagoDTO> mediosDePago;

	public HotelDTO(int hotelId, String nombre, DireccionDTO direccion, List<ImagenDTO> imagenes, List<ServicioDTO> servicios,
			List<HabitacionDTO> habitaciones, List<MedioDePagoDTO> mediosDePago) {
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

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public List<ImagenDTO> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDTO> imagenes) {
		this.imagenes = imagenes;
	}

	public List<ServicioDTO> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}

	public List<HabitacionDTO> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<HabitacionDTO> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<MedioDePagoDTO> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(List<MedioDePagoDTO> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

}
