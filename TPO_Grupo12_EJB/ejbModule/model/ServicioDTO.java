package model;

import java.io.Serializable;

public class ServicioDTO  implements Serializable{

	
	private static final long serialVersionUID = -7451111074491579417L;
	
	private int servicioId;
	private int key;
	private String descripcion;

	
	public ServicioDTO(int key, String descripcion) {
		this.key = key;
		this.descripcion = descripcion;
	}
	
	public ServicioDTO(int servicioId, int key, String descripcion) {
		this.servicioId = servicioId;
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

}
