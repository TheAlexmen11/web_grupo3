package web_grupo3;

public class Comentario {
	
	private int id_comentario;	
	private String nombre;
	private String correp;
	private int telefono;
	private String comentario;
	
	public int getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorrep() {
		return correp;
	}
	public void setCorrep(String correp) {
		this.correp = correp;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
