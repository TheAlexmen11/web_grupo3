package web_grupo3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comentario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_comentario;	
	private String nombre;
	private String correo;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
