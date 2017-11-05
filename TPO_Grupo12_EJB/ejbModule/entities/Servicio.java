package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.ServicioDTO;

@Entity
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int servicioId;
	
	private int clave;
	private String descripcion;

	public Servicio() {

	}

	public Servicio(int clave, String descripcion) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
	}
	
	public int getServicioId() {
		return servicioId;
	}
	

	public void setServicioId(int servicioId) {
		this.servicioId = servicioId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ServicioDTO toDTO(){
		return new ServicioDTO(servicioId, clave, descripcion);
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}
}
