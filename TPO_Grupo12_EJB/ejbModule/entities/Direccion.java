package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.DireccionDTO;

@Entity
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int direccionId;
	private String direccion;
	private String latitud;
	private String longitud;

	public Direccion(){
		
	}
	
	public Direccion(int direccionId, String direccion, String latitud, String longitud) {
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
	
	public DireccionDTO toDTO(){
		return new DireccionDTO(direccionId, direccion, latitud, longitud);
	}


}
