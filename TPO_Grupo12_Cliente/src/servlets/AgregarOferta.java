package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControladorBS;
import model.HabitacionDTO;
import model.HotelDTO;
import model.OfertaDTO;

@WebServlet("/AgregarOferta")
public class AgregarOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgregarOferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Date getDate(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(dateStr);
		} catch (final ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final int cupo = Integer.parseInt(request.getParameter("cupo"));
		final float precio = Float.parseFloat(request.getParameter("precio"));
		final Date fechaDesde = getDate(request.getParameter("fechaDesde"));
		final Date fechaHasta = getDate(request.getParameter("fechaHasta"));
		final String politicaDeCancelacion = request.getParameter("politicaDeCancelacion");

		final HotelDTO hotelDTO = ControladorBS.getInstancia()
				.obtenerHotel(Integer.parseInt(request.getParameter("hotel")));
		final HabitacionDTO habitacionDTO = ControladorBS.getInstancia()
				.obtenerHabitacion(Integer.parseInt(request.getParameter("habitacion")));

		OfertaDTO ofertaDTO = new OfertaDTO();
		ofertaDTO.setCupo(cupo);
		ofertaDTO.setFechaDesde(fechaDesde);
		ofertaDTO.setFechaHasta(fechaHasta);
		ofertaDTO.setPoliticaCancelacion(politicaDeCancelacion);
		ofertaDTO.setPrecio(precio);
		ofertaDTO.setHotel(hotelDTO);
		ofertaDTO.setHabitacion(habitacionDTO);

		ControladorBS.getInstancia().agregarOferta(ofertaDTO);

		request.setAttribute("hoteles", ControladorBS.getInstancia().obtenerHoteles());
		request.setAttribute("habitaciones", ControladorBS.getInstancia().obtenerHabitaciones());

		request.getRequestDispatcher("/ofertas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
