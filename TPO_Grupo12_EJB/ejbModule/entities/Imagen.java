package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imagenId;
	private String descripcion;
	private String path;

	public Imagen(int imagenId, String descripcion, String path) {
		super();
		this.imagenId = imagenId;
		this.descripcion = descripcion;
		this.path = path;
	}

	public int getImagenId() {
		return imagenId;
	}

	public void setImagenId(int imagenId) {
		this.imagenId = imagenId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
