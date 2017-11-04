package model;

import java.io.Serializable;

public class DireccionDTO implements Serializable{

	private int direccionId;
	private String direccion;
	private String latitud;
	private String longitud;

	public DireccionDTO(int direccionId, String direccion, String latitud, String longitud) {
		super();
		this.direccionId = direccionId;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public DireccionDTO(String direccion, String latitud, String longitud) {
		super();
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public int getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
