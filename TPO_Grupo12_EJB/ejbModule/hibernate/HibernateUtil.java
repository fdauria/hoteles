package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Direccion;
import entities.Habitacion;
import entities.Hotel;
import entities.Imagen;
import entities.MedioDePago;
import entities.Oferta;
import entities.Servicio;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Direccion.class);
			config.addAnnotatedClass(Habitacion.class);
			config.addAnnotatedClass(Hotel.class);
			config.addAnnotatedClass(Imagen.class);
			config.addAnnotatedClass(MedioDePago.class);
			config.addAnnotatedClass(Oferta.class);
			config.addAnnotatedClass(Servicio.class);

			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
