package integracion;

import java.io.Serializable;

public class LogBackOffice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String plataformaEnvia;
	private String plataformaRecibe;
	private String servicio;
	private String observacion;

	public LogBackOffice(String plataformaEnvia, String plataformaRecibe, String servicio, String observacion) {
		super();
		this.plataformaEnvia = plataformaEnvia;
		this.plataformaRecibe = plataformaRecibe;
		this.servicio = servicio;
		this.observacion = observacion;
	}
	
	public String getPlataformaEnvia() {
		return plataformaEnvia;
	}
	public void setPlataformaEnvia(String plataformaEnvia) {
		this.plataformaEnvia = plataformaEnvia;
	}
	public String getPlataformaRecibe() {
		return plataformaRecibe;
	}
	public void setPlataformaRecibe(String plataformaRecibe) {
		this.plataformaRecibe = plataformaRecibe;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	
}