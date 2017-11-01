package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedioDePago implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medioDePagoId;
	private String descripcion;
	
	public MedioDePago() {
		super();
	}
	
	public MedioDePago(int medioDePagoId, String descripcion) {
		super();
		this.medioDePagoId = medioDePagoId;
		this.descripcion = descripcion;
	}
	
	public int getMedioDePagoId() {
		return medioDePagoId;
	}
	public void setMedioDePagoId(int medioDePagoId) {
		this.medioDePagoId = medioDePagoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
