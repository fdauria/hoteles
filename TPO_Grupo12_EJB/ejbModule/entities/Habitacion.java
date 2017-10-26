package entities;

import java.util.ArrayList;
import java.util.List;

import model.HabitacionDTO;
import model.ImagenDTO;
import model.ServicioDTO;

public class Habitacion {

	private int habitacionId;
	private String descripcion;
	private int capacidad;
	private String tipo;
	private List<Imagen> imagenes;
	private List<Servicio> servicios;

	public Habitacion(int habitacionId, String descripcion, int capacidad, String tipo, List<Imagen> imagenes,
			List<Servicio> servicios) {
		super();
		this.habitacionId = habitacionId;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.imagenes = imagenes;
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
	
	public HabitacionDTO toDTO(){
		List<ImagenDTO> imagenDTOList = new ArrayList<ImagenDTO>();
		List<ServicioDTO> servicioDTOList = new ArrayList<ServicioDTO>();
		return new HabitacionDTO(habitacionId, descripcion, capacidad, tipo, imagenDTOList, servicioDTOList);
	}

}
