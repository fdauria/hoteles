package integracion;

public class Props {

	public Props(){
		
	}
	
	public static String connection_factory_value = "jms/RemoteConnectionFactory";
	public static String ofertaToJMS_PROVIDER_URL_value = "http-remoting://192.168.1.81:8080";

	public static String usernameOfertaToJMS = "hotelera";

	public static String passwordOfertaToJMS = "hotelera";
	public static String destinationOfertaToJMS = "jms/queue/ofertahotelera";
	public static String usernameConnOferta = "hotelera";
	public static String passwordConnOferta = "hotelera";
	public static String URL_SEND_HOTEL_BACKOFFICE = "http://192.168.0.108:8080/TPO_BO_WEB/rest/ServiciosBO/EnviarSolicitud";
	public static String URL_TO_LOG = "http://192.168.0.108:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog";
	
	public static String IP_LOCAL = "192.168.0.104";
}
