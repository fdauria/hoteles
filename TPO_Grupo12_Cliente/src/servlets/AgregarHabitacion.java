package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControladorBS;
import model.HabitacionDTO;
import model.HotelDTO;
import model.ServicioDTO;

@WebServlet("/AgregarHabitacion")
public class AgregarHabitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgregarHabitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final HotelDTO hotelDTO = ControladorBS.getInstancia()
				.obtenerHotel(Integer.parseInt(request.getParameter("hotel")));
		final String tipo = request.getParameter("tipo");
		final int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		final String descripcion = request.getParameter("descripcion");

		final List<ServicioDTO> servicioDTOList = new ArrayList<>();
		String[] serviciosArray = request.getParameterValues("servicios");
		if (serviciosArray != null) {
			for (String item : serviciosArray) {
				String keyValue[] = item.split(":");
				servicioDTOList.add(new ServicioDTO(Integer.parseInt(keyValue[0]), 2, keyValue[1]));
			}
		}

		// if (request.getParameter("imagen") != null)
		// agregarImagenHotel("imagen_" + nombre, request.getPart("file"));

		HabitacionDTO habitacionDTO = new HabitacionDTO();
		habitacionDTO.setCapacidad(capacidad);
		habitacionDTO.setDescripcion(descripcion);
		habitacionDTO.setHotel(hotelDTO);
		habitacionDTO.setServicios(servicioDTOList);
		habitacionDTO.setTipo(tipo);
		// habitacionDTO.setImagen(imagen);
		ControladorBS.getInstancia().agregarHabitacion(habitacionDTO);

		request.getRequestDispatcher("/habitaciones.jsp").forward(request, response);

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
