package model;

import java.io.Serializable;
import java.util.Date;

public class OfertaDTO  implements Serializable{

	
	private static final long serialVersionUID = 262180962856099850L;

	private int ofertaId;
	private Date fechaDesde;
	private Date fechaHasta;
	private float precio;
	private HabitacionDTO habitacion;
	private String politicaCancelacion;
	private HotelDTO hotel;
	private int cupo;

	public OfertaDTO() {

	}

	public OfertaDTO(int ofertaId, Date fechaDesde, Date fechaHasta, float precio, HabitacionDTO habitacion,
			String politicaCancelacion, HotelDTO hotelDTO, int cupo) {
		super();
		this.ofertaId = ofertaId;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.precio = precio;
		this.habitacion = habitacion;
		this.politicaCancelacion = politicaCancelacion;
		this.setHotel(hotelDTO);
		this.cupo = cupo;
	}
	
	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public int getOfertaId() {
		return ofertaId;
	}

	public void setOfertaId(int ofertaId) {
		this.ofertaId = ofertaId;
	}

	public Date getFechadDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public HabitacionDTO getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(HabitacionDTO habitacion) {
		this.habitacion = habitacion;
	}

	public String getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(String politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}
}
