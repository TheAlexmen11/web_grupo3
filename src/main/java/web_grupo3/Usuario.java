package web_grupo3;

public class Usuario {
    private int id_user;
	private String nom_user;
	private String username;
	private String password_hash;
	private String rol_user;
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNom_user() {
		return nom_user;
	}
	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword_hash() {
		return password_hash;
	}
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}
	public String getRol_user() {
		return rol_user;
	}
	public void setRol_user(String rol_user) {
		this.rol_user = rol_user;
	}


	

    
}
