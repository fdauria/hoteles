package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.OfertaDTO;

@Entity
public class Oferta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ofertaId;
	private Date fechaDesde;
	private Date fechaHasta;
	private float precio = 0;
	
	@ManyToOne
	@JoinColumn(name="hotelId")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name="habitacionId")
	private Habitacion habitacion;
	
	private String politicaCancelacion;

	private int cupo;
	
	public Oferta() {

	}

	public Oferta(int ofertaId, Date fechaDesde, Date fechaHasta, float precio, Hotel hotel, Habitacion habitacion,
			String politicaCancelacion, int cupo) {
		super();
		this.ofertaId = ofertaId;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.precio = precio;
		this.hotel=hotel;
		this.habitacion = habitacion;
		this.politicaCancelacion = politicaCancelacion;
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

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public String getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(String politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}
	
	public OfertaDTO toDTO(){
		return new OfertaDTO(ofertaId, fechaDesde, fechaHasta, precio, habitacion.toDTO(), politicaCancelacion,hotel.toDTO(), cupo);
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
}
