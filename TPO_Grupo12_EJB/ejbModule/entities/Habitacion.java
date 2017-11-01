package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import model.HabitacionDTO;
import model.ImagenDTO;
import model.ServicioDTO;

@Entity
public class Habitacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int habitacionId;
	private String descripcion;
	private int capacidad;
	private String tipo;
	
	@OneToMany
	private List<Servicio> servicios;

	public Habitacion(int habitacionId, String descripcion, int capacidad, String tipo,
			List<Servicio> servicios) {
		super();
		this.habitacionId = habitacionId;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.tipo = tipo;
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

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public HabitacionDTO toDTO(){
		List<ImagenDTO> imagenDTOList = new ArrayList<ImagenDTO>();
		List<ServicioDTO> servicioDTOList = new ArrayList<ServicioDTO>();
		return new HabitacionDTO(habitacionId, descripcion, capacidad, tipo, imagenDTOList, servicioDTOList);
	}

}
