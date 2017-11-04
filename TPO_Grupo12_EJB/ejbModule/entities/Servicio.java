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
	
	private int key;
	private String descripcion;

	public Servicio() {

	}

	public Servicio(int key, String descripcion) {
		super();
		this.key = key;
		this.descripcion = descripcion;
	}
	
	public int getServicioId() {
		return servicioId;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
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

	public ServicioDTO toDT(){
		return new ServicioDTO(servicioId, key, descripcion);
	}
}
