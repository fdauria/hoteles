package model;

import java.io.Serializable;

public class ServicioDTO  implements Serializable{

	
	private static final long serialVersionUID = -7451111074491579417L;
	
	private int servicioId;
	private int tipo;
	private String descripcion;

	public ServicioDTO() {

	}
	
	public ServicioDTO(int tipo, String descripcion) {
		
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	
	public ServicioDTO(int servicioId, int tipo, String descripcion) {
		this.servicioId = servicioId;
		this.descripcion = descripcion;
		this.tipo = tipo;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
