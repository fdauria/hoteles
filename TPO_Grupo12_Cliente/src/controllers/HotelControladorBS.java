package controllers;

import java.util.Hashtable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import controlador.Controlador;
import controlador.ControladorRemote;

@Path("/hello")
@Stateless
public class HotelControladorBS {

	@EJB
	private ControladorRemote controlador;

	@SuppressWarnings("unchecked")
	private HotelControladorBS() {
		try {
			@SuppressWarnings("rawtypes")
			final Hashtable conn = new Hashtable();
			conn.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context cont = new javax.naming.InitialContext(conn);
			controlador = (Controlador) cont.lookup(
					"ejb:TPO_Grupo12_EAR/TPO_Grupo12_EJB/" + "" + "/Controlador!" + ControladorRemote.class.getName());
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	public String hello(@QueryParam("name") String name) {
		return controlador.hello(name);
	}

}