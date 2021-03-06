package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private float price;
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToOne
	private Habitacion habitacion;
	private String politicaCancelacion;

	public Oferta() {

	}

	public Oferta(int ofertaId, Date fechaDesde, Date fechaHasta, float price, Hotel hotel, Habitacion habitacion,
			String politicaCancelacion) {
		super();
		this.ofertaId = ofertaId;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.price = price;
		this.hotel = hotel;
		this.habitacion = habitacion;
		this.politicaCancelacion = politicaCancelacion;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
		
		return new OfertaDTO(ofertaId, fechaDesde, fechaHasta, price, hotel.toDTO(), habitacion.toDTO(), politicaCancelacion);
	}
}
