package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Cliente;
import web_grupo3jpa.Usuario;

import java.io.IOException;
import java.util.List;

import ejb.EjbGestionCliente;
import ejb.EjbGestionUsuario;

@WebServlet("ServletClienteConsultar")
public class ServletClienteConsultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionCliente ejb;
     
    public ServletClienteConsultar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> Clientes = ejb.listarClientes();
        request.setAttribute("clientes",Clientes);
        request.getRequestDispatcher("/dash_cliente.jsp").forward(request, response);
	}


}
