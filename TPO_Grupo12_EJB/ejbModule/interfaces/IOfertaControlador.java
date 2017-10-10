package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.OfertaDTO;

@Remote
public interface IOfertaControlador {

	public List<OfertaDTO> obtenerOfertas();

	public OfertaDTO agregarOferta(OfertaDTO oferta);

	public OfertaDTO obtenerOferta(int id);

}
