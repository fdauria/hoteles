package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.HotelControladorBS;
import model.DireccionDTO;
import model.HotelDTO;
import model.MedioDePagoDTO;
import model.ServicioDTO;

@WebServlet("/AgregarHotel")
public class AgregarHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgregarHotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String direccionNombre = request.getParameter("direccionNombre");
		String direccionLatitude = request.getParameter("direccionLatitude");
		String direccionLongitud = request.getParameter("direccionLongitud");

		List<ServicioDTO> servicioDTOList = new ArrayList<>();
		String[] serviciosArray = request.getParameterValues("servicios");
		if (serviciosArray != null) {
			for (String item : serviciosArray) {
				String keyValue[] = item.split(":");
				servicioDTOList.add(new ServicioDTO(Integer.parseInt(keyValue[0]), keyValue[1]));
			}
		}

		List<MedioDePagoDTO> medioDePagoDTOList = new ArrayList<>();
		String[] medioDePagoList = request.getParameterValues("mediosDePago");
		if (medioDePagoList != null) {
			for (String item : medioDePagoList) {
				String keyValue[] = item.split(":");
				medioDePagoDTOList.add(new MedioDePagoDTO(Integer.parseInt(keyValue[0]), keyValue[1]));
			}
		}

		final DireccionDTO direccionDTO = new DireccionDTO(direccionNombre, direccionLatitude, direccionLongitud);

		final HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setNombre(nombre);
		hotelDTO.setDireccion(direccionDTO);
		hotelDTO.setServicios(servicioDTOList);
		hotelDTO.setMediosDePago(medioDePagoDTOList);

		System.out.println(hotelDTO.toString());
		HotelControladorBS.getInstancia().crearHotel(hotelDTO);

		this.getServletContext().getRequestDispatcher("./hoteles.jsp").forward(request, response);
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
