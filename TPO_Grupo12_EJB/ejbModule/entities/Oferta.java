package entities;

import java.util.Date;

import model.OfertaDTO;

public class Oferta {

	private int ofertaId;
	private Date fechaDesde;
	private Date fechaHasta;
	private float price;
	private Hotel hotel;
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
