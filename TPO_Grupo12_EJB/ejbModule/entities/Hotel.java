package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.internal.Nullable;

import model.HabitacionDTO;
import model.HotelDTO;
import model.ImagenDTO;
import model.MedioDePagoDTO;
import model.ServicioDTO;

@Entity
public class Hotel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
	private String nombre;
	
	@ManyToOne
	private Direccion direccion;
	
	@OneToMany
	private List<Servicio> servicios;
	
	@OneToMany
	private List<Habitacion> habitaciones;
	
	@OneToMany
	private List<MedioDePago> mediosDePago;
	
	private String image;

	public Hotel(int hotelId, String nombre, Direccion direccion, List<Servicio> servicios,
			List<Habitacion> habitaciones, List<MedioDePago> mediosDePago, @Nullable String image) {
		super();
		this.hotelId = hotelId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.servicios = servicios;
		this.habitaciones = habitaciones;
		this.mediosDePago = mediosDePago;
		this.image = image;
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
	
	public void setImage(String image){
		this.image = image;
	}
	
	public String getImage(){
		return this.image;
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
