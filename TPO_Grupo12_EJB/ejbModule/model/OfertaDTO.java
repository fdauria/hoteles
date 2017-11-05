package model;

import java.io.Serializable;
import java.util.Date;

public class OfertaDTO  implements Serializable{

	
	private static final long serialVersionUID = 262180962856099850L;

	private int ofertaId;
	private Date fechaDesde;
	private Date fechaHasta;
	private float price;
	private HabitacionDTO habitacion;
	private String politicaCancelacion;
	private HotelDTO hotel;

	public OfertaDTO() {

	}

	public OfertaDTO(int ofertaId, Date fechaDesde, Date fechaHasta, float price, HabitacionDTO habitacion,
			String politicaCancelacion, HotelDTO hotelDTO) {
		super();
		this.ofertaId = ofertaId;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.price = price;
		this.habitacion = habitacion;
		this.politicaCancelacion = politicaCancelacion;
		this.setHotel(hotelDTO);
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
