package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControladorBS;
import model.HabitacionDTO;

@WebServlet("/ObtenerHabitacionesPorHotel")
public class ObtenerHabitacionesPorHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ObtenerHabitacionesPorHotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			int hotel = Integer.parseInt(request.getParameter("hotel"));

			for (final HabitacionDTO habitacion : ControladorBS.getInstancia().obtenerHotel(hotel).getHabitaciones()) {
				out.print(
						"<option value='" + habitacion.getHabitacionId() + "'>" + habitacion.getNombre() + "</option>");
			}
		}
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
