package entities;

import java.util.ArrayList;
import java.util.List;

import model.HabitacionDTO;
import model.HotelDTO;
import model.ImagenDTO;
import model.MedioDePagoDTO;
import model.ServicioDTO;

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

	public HotelDTO toDTO(){
		List<ImagenDTO> imagenDTOList = new ArrayList<ImagenDTO>();
		List<ServicioDTO> servicioDTOList = new ArrayList<ServicioDTO>();
		List<HabitacionDTO> habitacionDTOList = new ArrayList<HabitacionDTO>();
		List<MedioDePagoDTO> medioDePagoDTOList = new ArrayList<MedioDePagoDTO>();
		
		return new HotelDTO(hotelId, nombre, direccion.toDTO(), imagenDTOList, servicioDTOList,
				habitacionDTOList, medioDePagoDTOList);
	}
}
