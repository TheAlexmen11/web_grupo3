package web_grupo3;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class conexion {

    // Método para obtener la conexión a la base de datos usando JNDI
    public static Connection getConexion() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/dbgrupo3");
        
        // Retornar la conexión obtenida del DataSource
        return ds.getConnection();
    }

}
