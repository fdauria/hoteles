package controlador;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Cacheable;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import integracion.LogBackOffice;
import integracion.NuevoEstablecimientoJSON;
import integracion.NuevoEstablecimientoResponse;
import integracion.OfertaJMS;
import integracion.Props;
import integracion.RequestServiciosTipo;
import integracion.ServiciosJSON;
import integracion.ServiciosPorTipoResponseJSON;
import manager.ManagerRemote;
import model.HabitacionDTO;
import model.HotelDTO;
import model.MedioDePagoDTO;
import model.OfertaDTO;
import model.ServicioDTO;

@Stateless
public class Controlador implements ControladorRemote {

	@EJB
	private ManagerRemote interfazRemota;
	
	private static Logger logger = Logger.getLogger(Controlador.class);
	
	public Controlador() {
	}
	
	@Override
	public List<HotelDTO> obtenerHoteles() {
		return interfazRemota.obtenerHoteles();
	}

	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {
		final HotelDTO hotelDTO = interfazRemota.agregarHotel(hotel);
		logger.info("Se ha solicitado la creación de un nuevo Establecimiento ");
		sendHotelToBackOffice(hotelDTO);
		return hotelDTO;
	}
	
	private void sendHotelToBackOffice(HotelDTO hotelDTO){
		URL url;
		try {
			toLog(new LogBackOffice("OH", "BO", "Crear establecimiento", "INFO"));
			
			url = new URL(Props.URL_SEND_HOTEL_BACKOFFICE);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "application/json");
			
			IOUtils.write(new Gson().toJson(new NuevoEstablecimientoJSON("Hotelera", hotelDTO.getNombre())), urlConnection.getOutputStream());
			NuevoEstablecimientoResponse response = new Gson().fromJson(IOUtils.toString(urlConnection.getInputStream()), NuevoEstablecimientoResponse.class);
			hotelDTO.setBackofficeId(response.getId());
			
			//REVISAR QUE PERSISTA EL ID DEL BACKOFFICE
			interfazRemota.actualizarConIdBackoffice(hotelDTO);
		} catch (Exception e) {
			try {
				toLog(new LogBackOffice("OH", "BO", "Crear establecimiento", "ERROR : " + e.getMessage()));
			} catch (IOException e1) {
				logger.error("Fallo al enviar el establecimiento --> Error de conexion: "+e1.getMessage());
			}
		}
	}
	
	public List<ServiciosJSON> obtenerServicios() throws IOException{
		URL url;
		url = new URL(Props.URL_OBTENER_SERVICIOS);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoInput(true);
		urlConnection.setRequestMethod("GET");
		final ServiciosJSON[] listServHabitacion = new Gson().fromJson((Reader)new InputStreamReader(urlConnection.getInputStream()), ServiciosJSON[].class);

		List<ServiciosJSON> seree = new ArrayList<ServiciosJSON>();
		return seree;
	}
	
	
	public List<ServicioDTO> obtenerServiciosPorTipoRest(String tipo) throws IOException{
		toLog(new LogBackOffice("OH", "BO", "Obtener servicios por tipo", ""));

		//DESDE ACA NO TOCAR (ES LO DE AGUS FUNCIONANDO)
		URL url = new URL(Props.URL_OBTENER_SERVICIOS_POR_TIPO);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("Content-Type", "application/json");
		
		RequestServiciosTipo req =  new RequestServiciosTipo();
		req.setNombre(tipo);
		
		IOUtils.write(new Gson().toJson(req), urlConnection.getOutputStream());
		ServiciosPorTipoResponseJSON[] response = new Gson().fromJson(IOUtils.toString(urlConnection.getInputStream()), ServiciosPorTipoResponseJSON[].class);
		//HASTA ACA  NO TOCAR (ES LO DE AGUS FUNCIONANDO)
		
		List<ServicioDTO> serviciosDTO = new ArrayList<ServicioDTO>();
		
		for (int i=0 ;i<response.length; i++) {
			ServicioDTO servicioDTO = new ServicioDTO();
			servicioDTO.setDescripcion(response[i].getNombre());
			servicioDTO.setServicioId(Integer.valueOf(response[i].getId()));
			servicioDTO.setTipo(Integer.valueOf(response[i].getTipo().getId()));
			serviciosDTO.add(servicioDTO);
		}
		return serviciosDTO;
	}
	
	public void toLog(LogBackOffice log) throws IOException{
		URL url = new URL(Props.URL_TO_LOG);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("Content-Type", "application/json");

		IOUtils.write(new Gson().toJson(log), urlConnection.getOutputStream());
		String response = IOUtils.toString(urlConnection.getInputStream());
	}
	
	public void ofertaToJMS(OfertaDTO o){
		
		try {
			toLog(new LogBackOffice("OH", "PW", "Crear oferta hotelera", ""));
		} catch (IOException e1) {
			logger.error("Fallo al enviar el log al BackOffice --> Error de conexion: "+e1.getMessage());
		}

		Context context;
		try 
		{
		    final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, Props.ofertaToJMS_PROVIDER_URL_value);
            env.put(Context.SECURITY_PRINCIPAL, Props.usernameConnOferta);
            env.put(Context.SECURITY_CREDENTIALS, Props.passwordConnOferta);
            context = new InitialContext(env);
 
            // Perform the JNDI lookups
            String connectionFactoryString = Props.connection_factory_value;
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
 
            String destinationString = Props.destinationOfertaToJMS;
            Destination destination = (Destination) context.lookup(destinationString);
 
            Connection connection = connectionFactory.createConnection(Props.usernameConnOferta, Props.passwordConnOferta);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			
			final HotelDTO h = o.getHotel();
            final HabitacionDTO hab = o.getHabitacion();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
            final OfertaJMS ofertaJMS = new OfertaJMS("OH_12_" + h.getBackofficeId(),
        		h.getNombre(),
        		h.getDireccion().getDestino(),
        		simpleDateFormat.format(o.getFechadDesde()),
        		simpleDateFormat.format(o.getFechaHasta()),
        		o.getHabitacion().getCapacidad(),
        		h.getImagen(),
        		h.getNombre(),
        		h.getServicios(),
        		o.getPrecio(),
        		o.getHabitacion().getImagen(),
        		o.getHabitacion().getDescripcion(),
        		o.getHabitacion().getServicios(),
        		h.getDireccion().getLatitud(),
        		h.getDireccion().getLongitud(),
        		o.getPoliticaCancelacion(),
        		h.getMediosDePago(),
        		"",
        		o.getCupo()
    		);
			
			
			message.setText(new Gson().toJson(ofertaJMS));
			
			producer.send(message);
			connection.close();
		} catch (Exception e) {
			logger.error("Fallo al enviar la oferta al BackOffice: "+e.getMessage());
		}
	}

	@Override
	public HotelDTO obtenerHotel(int id) {
		return interfazRemota.obtenerHotel(id);
	}

	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return interfazRemota.obtenerOfertas();
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO oferta) {
		OfertaDTO ofertaDTO =  interfazRemota.agregarOferta(oferta);
		logger.info("Se ha solicitado la creación de una nueva Oferta ");
		ofertaToJMS(ofertaDTO);
		return ofertaDTO;
	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return interfazRemota.obtenerOferta(id);
	}

	@Override
	public List<HabitacionDTO> obtenerHabitaciones() {
		return interfazRemota.obtenerHabitaciones();
	}

	@Override
	public HabitacionDTO obtenerHabitacion(int id) {
		return interfazRemota.obtenerHabitacion(id);
	}

	@Override
	public HabitacionDTO agregarHabitacion(HotelDTO hotelDTO, HabitacionDTO habitacionDTO){
		return interfazRemota.agregarHabitacion(hotelDTO, habitacionDTO);
	}
	
	@Override
	public List<ServicioDTO> obtenerServiciosPorTipo(int tipo){
		try {
			String tipoServicio = "";
			if(tipo==1){
				tipoServicio = "Hotel";
			}
			if(tipo==2){
				tipoServicio = "Habitacion";
			}
			 List<ServicioDTO> listServiciosDTOs = obtenerServiciosPorTipoRest(tipoServicio);
			 interfazRemota.cargarServiciosPorTipo(listServiciosDTOs);
			 return listServiciosDTOs;
		} catch (IOException e) {
			logger.error("Fallo al obtener los servicios de BackOffice --> Error de conexion: "+e.getMessage());
			logger.info("Se recuperan los servicios de BackOffice de nuestra base ");
		}
		return interfazRemota.obtenerServiciosPorTipo(tipo);
	}

	@Override
	public List<MedioDePagoDTO> obtenerMediosDePago() {
		return interfazRemota.obtenerMediosDePago();
	}

	@Override
	public void cargarServicios() {
		interfazRemota.cargarServicios();
	}

	@Override
	public void cargarMediosDePago() {
		interfazRemota.cargarMediosDePago();
	}
	
}
