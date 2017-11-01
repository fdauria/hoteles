package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.DireccionDTO;

@Entity
public class Direccion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int direccionId;
	private String direccion;
	private float latitud;
	private float longitud;

	public Direccion(int direccionId, String direccion, float latitud, float longitud) {
		super();
		this.direccionId = direccionId;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public DireccionDTO toDTO(){
		return new DireccionDTO(direccionId, direccion, latitud, longitud);
	}

}
