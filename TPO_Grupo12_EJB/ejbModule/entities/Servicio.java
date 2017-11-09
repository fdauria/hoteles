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
	private int tipo;
	private String descripcion;

	public Servicio() {

	}

	public Servicio(int tipo, String descripcion) {
		super();
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	
	public int getServicioId() {
		return servicioId;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
		return new ServicioDTO(servicioId, tipo, descripcion);
	}

}
