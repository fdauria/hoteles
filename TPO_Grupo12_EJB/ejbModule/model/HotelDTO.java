package model;

import java.io.Serializable;
import java.util.List;

import com.sun.istack.internal.Nullable;

public class HotelDTO  implements Serializable{

	private static final long serialVersionUID = -829612922676097149L;

	private int hotelId;
	private String nombre;
	private DireccionDTO direccion;
	private List<ServicioDTO> servicios;
	private List<HabitacionDTO> habitaciones;
	private List<MedioDePagoDTO> mediosDePago;
	private String imagen;
	
	public HotelDTO(int hotelId, String nombre, DireccionDTO direccion, List<ServicioDTO> servicios,
			@Nullable List<HabitacionDTO> habitaciones, List<MedioDePagoDTO> mediosDePago, @Nullable String imagen) {
		super();
		this.hotelId = hotelId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.servicios = servicios;
		this.habitaciones = habitaciones;
		this.mediosDePago = mediosDePago;
		this.imagen = imagen;
	}
	
	public HotelDTO( String nombre, DireccionDTO direccion, List<ServicioDTO> servicios,
			@Nullable List<HabitacionDTO> habitaciones, List<MedioDePagoDTO> mediosDePago, @Nullable String imagen) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.servicios = servicios;
		this.habitaciones = habitaciones;
		this.mediosDePago = mediosDePago;
		this.imagen = imagen;
	}
	
	public HotelDTO() {		
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
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "HotelDTO [hotelId=" + hotelId + ", nombre=" + nombre + ", direccion=" + direccion 
				+ ", servicios=" + servicios + ", habitaciones=" + habitaciones + ", mediosDePago="
				+ mediosDePago + "]";
	}

}
