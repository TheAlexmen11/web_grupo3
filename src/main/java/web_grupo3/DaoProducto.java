package web_grupo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DaoProducto {
	public List<Producto> consultarTodos() {
		List<Producto> lst = new ArrayList<Producto>();
		Context ctx=null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataSource ds=null;
		try {
			ds = (DataSource)ctx.lookup("jdbc/dbgrupo3");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection cnx = ds.getConnection();
			String sql ="SELECT * FROM productos";
			PreparedStatement st = cnx.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto e = new Producto();
				e.setId_product(rs.getInt(1));
				e.setTipo_product(rs.getString(2));
				e.setMarca_product(rs.getString(3));
				e.setDescripcion_product(rs.getString(4));
				e.setImg_product(rs.getString(5));
				e.setPrecio_product(rs.getDouble(6));
				lst.add(e);
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}
}
