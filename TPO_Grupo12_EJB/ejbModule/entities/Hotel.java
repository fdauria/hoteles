package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = 	"direccionId")
	private Direccion direccion;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="Hotel_Servicio", joinColumns={@JoinColumn(name="hotelId")}, inverseJoinColumns={@JoinColumn(name="servicioId")})
	private List<Servicio> servicios  = new ArrayList<Servicio>();
	
	@OneToMany(mappedBy="hotel") 
	private List<Habitacion> habitaciones = new ArrayList<Habitacion>();	
	
	private String imagen;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="Hotel_MedioDePago", joinColumns={@JoinColumn(name="hotelId")}, inverseJoinColumns={@JoinColumn(name="medioDePagoId")})
	private List<MedioDePago> mediosDePago  = new ArrayList<MedioDePago>();
	
	
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

	public HotelDTO toDTO(){
		final List<ServicioDTO> servicioDTOList 		= servicios.stream().map(servicio -> servicio.toDTO()).collect(Collectors.toList());
		final List<HabitacionDTO> habitacionDTOList 	= habitaciones.stream().map(habitacion -> habitacion.toDTO()).collect(Collectors.toList());
		final List<MedioDePagoDTO> medioDePagoDTOList 	= mediosDePago.stream().map(medioDePago -> medioDePago.toDTO()).collect(Collectors.toList());
		
		return new HotelDTO(hotelId, nombre, direccion.toDTO(), servicioDTOList,habitacionDTOList, medioDePagoDTOList, imagen);
	}
}
