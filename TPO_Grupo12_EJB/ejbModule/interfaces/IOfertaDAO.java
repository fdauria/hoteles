package interfaces;

import java.util.List;

import javax.ejb.Local;

import model.OfertaDTO;

@Local
public interface IOfertaDAO {

	public List<OfertaDTO> obtenerOfertas();

	public OfertaDTO agregarOferta(OfertaDTO oferta);

	public OfertaDTO obtenerOferta(int id);

}
