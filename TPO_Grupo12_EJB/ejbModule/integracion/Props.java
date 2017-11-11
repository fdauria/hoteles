package integracion;

public class Props {

	public Props(){
		
	}
	
	public static String connection_factory_value = "jms/RemoteConnectionFactory";
	public static String ofertaToJMS_PROVIDER_URL_value = "http-remoting://192.168.0.101:8080";

	public static String usernameOfertaToJMS = "hornetq";

	public static String passwordOfertaToJMS = "hornetq";
	public static String destinationOfertaToJMS = "jms/queue/ofertasHotel";
	public static String usernameConnOferta = "hornetq";
	public static String passwordConnOferta = "hornetq";
	public static String URL_SEND_HOTEL_BACKOFFICE 	= "http://192.168.0.107:8080/TPO_BO_WEB/rest/ServiciosBO/EnviarSolicitud";
	public static String URL_TO_LOG 				= "http://192.168.0.107:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog";
	
	public static String IP_LOCAL = "192.168.0.104";
}
