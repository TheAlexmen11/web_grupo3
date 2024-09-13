package web_grupo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoLogin {
	    public boolean validarUsuario(String username, String passwordHash) {
	        boolean isValid = false;
	        Context ctx = null;
	        try {
	            ctx = new InitialContext();
	            DataSource ds = (DataSource) ctx.lookup("jdbc/dbgrupo3");
	            Connection cnx = ds.getConnection();
	            
	         // Imprimir username y passwordHash en consola para debug de conexion con dbgrupo3
	            System.out.println("Usuario: " + username + ", Contraseña: " + passwordHash);
	           
	            String sql = "SELECT username,password_hash FROM usuario WHERE username = ? AND password_hash = ?";
	            PreparedStatement st = cnx.prepareStatement(sql);
	            st.setString(1, username);
	            st.setString(2, passwordHash);
	            ResultSet rs = st.executeQuery();
	            if (rs.next()) {
	                isValid = true;
	            }
	            cnx.close();
	        } catch (NamingException | SQLException e) {
	            e.printStackTrace();
	        }
	        return isValid;
	    }
	}