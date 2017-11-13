package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import controllers.ControladorBS;
import model.HabitacionDTO;
import model.HotelDTO;
import model.ServicioDTO;
import properties.EJBProperties;

@WebServlet("/AgregarHabitacion")
public class AgregarHabitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	EJBProperties properties;

	public AgregarHabitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> serviciosList = new ArrayList<String>();
		String tipo = "";
		String nombre = "";
		int capacidad = 0;
		String descripcion = "";
		HotelDTO hotelDTO = null;
		String imagen = "";

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
		String uploadContextPath = getServletContext().getContextPath() + File.separator + "uploads";

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			Iterator<FileItem> iterator = upload.parseRequest(request).iterator();
			while (iterator.hasNext()) {
				FileItem item = (FileItem) iterator.next();
				if (item.isFormField()) {
					switch (item.getFieldName()) {
					case "tipo":
						tipo = item.getString();
						break;
					case "nombre":
						nombre = item.getString();
						break;
					case "capacidad":
						capacidad = Integer.parseInt(item.getString());
						break;
					case "descripcion":
						descripcion = item.getString();
						break;
					case "hotel":
						hotelDTO = ControladorBS.getInstancia().obtenerHotel(Integer.parseInt(item.getString()));
						break;
					case "servicios":
						serviciosList.add(item.getString());
						break;
					default:
						break;
					}
				} else if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					fileName = "habitacion" + timestamp.getTime();
					String filePath = uploadPath + File.separator + fileName + ".jpg";
					String fileContextPath = properties.getProperties().getProperty("IP_LOCAL") + uploadContextPath
							+ File.separator + fileName + ".jpg";

					File storeFile = new File(filePath);
					// saves the file on disk
					item.write(storeFile);

					imagen = fileContextPath;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ServicioDTO> servicioDTOList = new ArrayList<>();
		for (final String item : serviciosList) {
			String keyValue[] = item.split(":");
			servicioDTOList.add(new ServicioDTO(Integer.parseInt(keyValue[0]), 1, keyValue[1]));
		}

		final HabitacionDTO habitacionDTO = new HabitacionDTO();
		habitacionDTO.setNombre(nombre);
		habitacionDTO.setCapacidad(capacidad);
		habitacionDTO.setDescripcion(descripcion);
		habitacionDTO.setHotel(hotelDTO);
		habitacionDTO.setServicios(servicioDTOList);
		habitacionDTO.setTipo(tipo);
		habitacionDTO.setImagen(imagen);

		ControladorBS.getInstancia().agregarHabitacion(hotelDTO, habitacionDTO);

		request.setAttribute("servicios", ControladorBS.getInstancia().obtenerServiciosPorTipo(2));
		request.setAttribute("hoteles", ControladorBS.getInstancia().obtenerHoteles());

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
