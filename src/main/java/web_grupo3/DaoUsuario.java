package web_grupo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.naming.NamingException;


public class DaoUsuario extends conexion {
	
	
	
	public List<Usuario> consultarTodos() throws NamingException, SQLException {
		List<Usuario> lst = new ArrayList<Usuario>();
		
		Connection cnx = conexion.getConexion();
		
		try {
			String sql ="SELECT * FROM usuario";
			PreparedStatement st = cnx.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId_user(rs.getInt(1));
				u.setNom_user(rs.getString(2));
				u.setUsername(rs.getString(3));
				u.setPassword_hash(rs.getString(4));
				u.setRol_user(rs.getString(5));
				lst.add(u);
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lst;
	}
	
	
	
	public void  registrarTodos(Usuario u) throws NamingException, SQLException {
		
		Connection cnx = conexion.getConexion();
				
		String sql = "INSERT INTO usuario (nom_user, username, password_hash, rol_user) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement st = cnx.prepareStatement(sql);
			
            st.setString(1, u.getNom_user());
            st.setString(2, u.getUsername());
            st.setString(3, u.getPassword_hash());
            st.setString(4, u.getRol_user());
			
            st.executeUpdate(); 
            cnx.close();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void eliminarUsuario(int userId) throws NamingException, SQLException {
		Connection cnx = conexion.getConexion();
		System.out.println(userId);
		String sql = "DELETE FROM usuario WHERE id_user = ?";
		try {
		PreparedStatement st = cnx.prepareStatement(sql);
		st.setInt(1, userId);
		st.executeUpdate();
		cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  List<Usuario> consultarUsuario(int userId) throws NamingException, SQLException {
		List<Usuario> lst = new ArrayList<Usuario>();
		Connection cnx = conexion.getConexion();
		System.out.println(userId);
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		try {
		PreparedStatement st = cnx.prepareStatement(sql);
		st.setInt(1, userId);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Usuario u = new Usuario();
			u.setId_user(rs.getInt(1));
			u.setNom_user(rs.getString(2));
			u.setUsername(rs.getString(3));
			u.setPassword_hash(rs.getString(4));
			u.setRol_user(rs.getString(5));
			lst.add(u);
		}
		cnx.close();
		cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
		
	}
	
}
