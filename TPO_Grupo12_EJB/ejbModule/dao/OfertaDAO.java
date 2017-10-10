package dao;

import java.util.List;

import entities.Oferta;
import model.OfertaDTO;

public class OfertaDAO {

	public static OfertaDAO instancia = null;

	public static OfertaDAO getInstancia() {
		if (instancia == null)
			instancia = new OfertaDAO();

		return instancia;
	}

	public void OfertaDAO() {

	}

	public List<Oferta> getAll() {
		return null;
	}

	public Oferta agregarOferta(OfertaDTO ofertaDto) {
		return null;
	}
}
