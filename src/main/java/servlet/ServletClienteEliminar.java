package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import ejb.EjbGestionCliente;

@WebServlet("ServletClienteEliminar")
public class ServletClienteEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionCliente ejb;
    public ServletClienteEliminar() {
        super();
		
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idToDelete"));
		System.out.println(request.getParameter("idToDelete"));
		ejb.eliminarCliente(id);
		request.getRequestDispatcher("dash_cliente.jsp").forward(request, response);
	}

}
