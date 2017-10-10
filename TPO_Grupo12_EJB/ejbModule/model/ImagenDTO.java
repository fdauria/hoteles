package model;

public class ImagenDTO {

	private int imagenId;
	private String descripcion;
	private String path;

	public ImagenDTO(int imagenId, String descripcion, String path) {
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
