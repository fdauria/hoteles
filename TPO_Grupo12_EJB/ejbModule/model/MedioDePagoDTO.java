package model;

import java.io.Serializable;

public class MedioDePagoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int medioDePagoId;
	private String descripcion;
	
	public MedioDePagoDTO() {
	}
	
	public MedioDePagoDTO(int medioDePagoId, String descripcion) {
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
