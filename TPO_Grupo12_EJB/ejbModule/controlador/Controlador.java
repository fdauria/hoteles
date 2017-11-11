package controlador;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import entities.Habitacion;
import integracion.LogBackOffice;
import integracion.NuevoEstablecimientoJSON;
import integracion.NuevoEstablecimientoResponse;
import integracion.Props;
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

	public Controlador() {
	}
	
	@Override
	public List<HotelDTO> obtenerHoteles() {
		return interfazRemota.obtenerHoteles();
	}

	@Override
	public HotelDTO agregarHotel(HotelDTO hotel) {
		final HotelDTO hotelDTO = interfazRemota.agregarHotel(hotel);
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
				System.out.println("Fallo al enviar el establecimiento --> Error de conexion");
			}
		}
	}
	
	public void toLog(LogBackOffice log) throws IOException{
		URL url2;
		url2 = new URL(Props.URL_TO_LOG);
		HttpURLConnection urlConnection2 = (HttpURLConnection) url2.openConnection();
		urlConnection2.setDoOutput(true);
		urlConnection2.setRequestMethod("POST");
		urlConnection2.setRequestProperty("Content-Type", "application/json");

		IOUtils.write(new Gson().toJson(log), urlConnection2.getOutputStream());
		String response = IOUtils.toString(urlConnection2.getInputStream());
	}
	
	public void ofertaToJMS(){
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
			message.setText("hola");
			producer.send(message);
			connection.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		/*Context namingContext = null;
        JMSContext jmsContext = null;
        try {
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, "http-remoting://192.168.0.101:8080");
            env.put(Context.SECURITY_PRINCIPAL, "hotel");
            env.put(Context.SECURITY_CREDENTIALS, "hotel");
            
            
            Context context;
            try 
            {
                final Properties env = new Properties();
                        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
                        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "http-remoting://192.168.0.101:8080"));
                        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "hotel"));
                        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "hotel"));
                        context = new InitialContext(env);
             
                        // Perform the JNDI lookups
                        String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
                        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
             
                        String destinationString = System.getProperty("destination", "jms/queue/ofertahotelera");
                        Destination destination = (Destination) context.lookup(destinationString);
             
                        // Create the JMS connection, session, producer, and consumer
                        Connection connection = connectionFactory.createConnection(System.getProperty("username", "hotel"), System.getProperty("password", "hotel"));
                        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                       // consumer = session.createConsumer(destination);
                        connection.start();
            // crear un producer para enviar mensajes usando la session
            MessageProducer producer = session.createProducer(destination);
            // crear un mensaje de tipo text y setearle el contenido
            TextMessage message = session.createTextMessage();
            message.setText("hola");
            // enviar el mensaje
            producer.send(message);
            // TODO: recordar cerrar la session y la connection en un bloque â€œfinallyâ€�
            connection.close();
            } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
            
            /*
            namingContext = new InitialContext(env);

            ConnectionFactory connectionFactory = (ConnectionFactory) namingContext.lookup("jms/RemoteConnectionFactory");
            System.out.println("Got ConnectionFactory");

            //Destination destination = (Destination) namingContext.lookup("jms/queue/ofertasHotel");
            Destination destination = (Destination) namingContext.lookup("jms/queue/ofertahotelera");

            System.out.println("Got JMS Endpoint");

            jmsContext = connectionFactory.createContext("hotel", "hotel");

           /* HotelDTO h = new HotelDTO();
            OfertaDTO o = new OfertaDTO();
            HabitacionDTO hab = new HabitacionDTO();
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
            OfertaJMS ofertaJMS = new OfertaJMS(h.getBackofficeId(),
            		h.getNombre(),
            		h.getDireccion().getDireccion(),
            		simpleDateFormat.format(o.getFechadDesde()),
            		simpleDateFormat.format(o.getFechaHasta()),
            		o.getHabitacion().getCapacidad(),
            		h.getImagen(),
            		h.getNombre(),
            		h.getServicios(),
            		o.getPrice(),
            		o.getHabitacion().getImagen(),
            		o.getHabitacion().getServicios(),
            		h.getDireccion().getLatitud(),
            		h.getDireccion().getLongitud(),
            		o.getPoliticaCancelacion(),
            		h.getMediosDePago(),
            		h.getEmail(),
            		o.getHabitacion().getCapacidad());//esto esta en duda
            		
            		
            		);
            TextMessage message = jmsContext.createTextMessage("{" +
                    "\"codigo_prestador\": \"OH_1_1\", " +
                    "\"nombre\": \"Dazzler\", " +
                    "\"destino\": \"Miami\", " +
                    "\"fecha_desde\": \"20170920\", " +
                    "\"fecha_hasta\": \"20170920\", " +
                    "\"cantidad_personas\": 1, " +
                    "\"foto_hotel\": \"http://www3.hilton.com/resources/media/hi/MLAHITW/en_US/img/shared/full_page_image_gallery/main/HL_exterior01_1270x560_FitToBoxSmallDimension_Center.jpg\", " +
                    "\"descripcion_hotel\": \"Descripcion Hotel\", " +
                    "\"lista_servicios\": [\"Wifi\", \"Frigo Bar\"], " +
                    "\"precio_habitacion\": 10.5, " +
                    "\"foto_habitacion\": \"http://www3.hilton.com/resources/media/hi/MLAHITW/en_US/img/shared/full_page_image_gallery/main/HL_exterior01_1270x560_FitToBoxSmallDimension_Center.jpg\", " +
                    "\"descripcion_habitacion\": \"Descripcion\", " +
                    "\"lista_servicios_habitacion\": [\"Wifi\", \"Frigo Bar\"], " +
                    "\"latitud\": -34.606299, " +
                    "\"longitud\": -58.364667, " +
                    "\"politica_cancelacion\": \"Politica de cancelacion\", " +
                    "\"medio_pago_hotel\": [1,2,3], " +
                    "\"email_hotel\": \"email@hotel.com\", " +
                    "\"cupo\": 10 " +
                    "}");

            jmsContext.createProducer().send(destination, message);
            System.out.println("Sent message");
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println(e);
            
        } finally {
            if (namingContext != null) {
                namingContext.close();
            }
            if (jmsContext != null) {
                jmsContext.close();
            }
        }
    
		 */
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
		ofertaToJMS();
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
