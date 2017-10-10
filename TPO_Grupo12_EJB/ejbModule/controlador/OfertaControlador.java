package controlador;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import interfaces.IOfertaControlador;
import interfaces.IOfertaDAO;
import model.OfertaDTO;

@Stateless
public class OfertaControlador implements IOfertaControlador {

	@EJB
	private IOfertaDAO iOfertaDAO;

	public OfertaControlador() {
	}

	@Override
	public List<OfertaDTO> obtenerOfertas() {
		return iOfertaDAO.obtenerOfertas();
	}

	@Override
	public OfertaDTO agregarOferta(OfertaDTO oferta) {
		return iOfertaDAO.agregarOferta(oferta);
	}

	@Override
	public OfertaDTO obtenerOferta(int id) {
		return iOfertaDAO.obtenerOferta(id);
	}

}
