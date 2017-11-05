package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.internal.Nullable;

import model.HabitacionDTO;
import model.HotelDTO;
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
	
	@OneToMany @JoinColumn(name="hotel")
	private List<Habitacion> habitaciones;
	
	@OneToMany
	private List<MedioDePago> mediosDePago;
	
	@OneToMany @JoinColumn(name="hotel")
	private List<Oferta> ofertas;
	
	private String imagen;
	
	public Hotel(){
		
	}

	public Hotel(String nombre, Direccion direccion, List<Servicio> servicios,
			@Nullable List<Habitacion> habitaciones, List<MedioDePago> mediosDePago, @Nullable String imagen, @Nullable List<Oferta> ofertas) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.servicios = servicios;
		this.habitaciones = habitaciones;
		this.mediosDePago = mediosDePago;
		this.imagen = imagen;
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
	
	public void setImagen(String imagen){
		this.imagen = imagen;
	}
	
	public String getImagen(){
		return this.imagen;
	}
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public HotelDTO toDTO(){
		List<ServicioDTO> servicioDTOList = new ArrayList<ServicioDTO>();
		List<HabitacionDTO> habitacionDTOList = new ArrayList<HabitacionDTO>();
		List<MedioDePagoDTO> medioDePagoDTOList = new ArrayList<MedioDePagoDTO>();
		
		return new HotelDTO(hotelId, nombre, direccion.toDTO(), servicioDTOList,habitacionDTOList, medioDePagoDTOList, imagen);
	}
}
