package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import controllers.ControladorBS;
import integracion.Props;
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> serviciosList = new ArrayList<String>();
		List<String> medioDePagoList = new ArrayList<String>();
		String nombre = "";
		String destino = "";
		String direccionNombre = "";
		String direccionLatitude = "";
		String direccionLongitud = "";
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
					case "nombre":
						nombre = item.getString();
						break;
					case "destino":
						destino = item.getString();
						break;
					case "direccionNombre":
						direccionNombre = item.getString();
						break;
					case "direccionLatitude":
						direccionLatitude = item.getString();
						break;
					case "direccionLongitud":
						direccionLongitud = item.getString();
						break;
					case "servicios":
						serviciosList.add(item.getString());
						break;
					case "mediosDePago":
						medioDePagoList.add(item.getString());
						break;
					default:
						break;
					}
				} else if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					fileName = "hotel" + timestamp.getTime();
					String filePath = uploadPath + File.separator + fileName + ".jpg";
					String fileContextPath = Props.IP_LOCAL + uploadContextPath + File.separator + fileName + ".jpg";

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

		List<MedioDePagoDTO> medioDePagoDTOList = new ArrayList<>();
		for (final String item : medioDePagoList) {
			String keyValue[] = item.split(":");
			medioDePagoDTOList.add(new MedioDePagoDTO(Integer.parseInt(keyValue[0]), keyValue[1]));
		}

		final DireccionDTO direccionDTO = new DireccionDTO(destino, direccionNombre, direccionLatitude,
				direccionLongitud);

		final HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setNombre(nombre);
		hotelDTO.setDireccion(direccionDTO);
		hotelDTO.setServicios(servicioDTOList);
		hotelDTO.setMediosDePago(medioDePagoDTOList);
		hotelDTO.setImagen(imagen);

		ControladorBS.getInstancia().agregarHotel(hotelDTO);

		request.setAttribute("servicios", ControladorBS.getInstancia().obtenerServiciosPorTipo(1));
		request.setAttribute("mediosDePago", ControladorBS.getInstancia().obtenerMediosDePago());

		this.getServletContext().getRequestDispatcher("/hoteles.jsp").forward(request, response);
	}
}
