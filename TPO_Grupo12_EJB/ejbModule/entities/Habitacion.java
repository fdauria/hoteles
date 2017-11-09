package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.HabitacionDTO;
import model.ServicioDTO;

@Entity
public class Habitacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int habitacionId;
	private String nombre;
	private String descripcion;
	private int capacidad;
	private String tipo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Habitacion_Servicio", 
	    joinColumns = {@JoinColumn(name = "habitacionId")},
	    inverseJoinColumns = {@JoinColumn(name = "servicioId")})
	private List<Servicio> servicios;
	
	private String imagen;

	public Habitacion(int habitacionId, String descripcion, int capacidad, String tipo,
			List<Servicio> servicios,Hotel hotel, String imagen) {
		super();
		this.habitacionId = habitacionId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.servicios = servicios;
		this.imagen = imagen;
	}

	public Habitacion() {
		
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HabitacionDTO toDTO(){
		List<ServicioDTO> servicioDTOList = new ArrayList<ServicioDTO>();
		return new HabitacionDTO(habitacionId, nombre, descripcion, capacidad, tipo, servicioDTOList, imagen);
	}
}
