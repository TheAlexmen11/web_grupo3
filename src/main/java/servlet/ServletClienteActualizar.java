package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Cliente;

import java.io.IOException;

import ejb.EjbGestionCliente;

public class ServletClienteActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionCliente ejb;
	
    public ServletClienteActualizar() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id_cliente1"));
		System.out.println(request.getParameter("nom_cliente1"));
		System.out.println(request.getParameter("dni_cliente1"));
		System.out.println(request.getParameter("email_cliente1"));
		System.out.println(request.getParameter("telefono_cliente1"));
		
		Cliente cliente = ejb.obtenerClientePorId(Integer.parseInt(request.getParameter("id_cliente1")));
		cliente.setNomCliente(request.getParameter("nom_cliente1"));
		cliente.setDniCliente(Integer.parseInt(request.getParameter("dni_cliente1")));
		cliente.setEmailCliente(request.getParameter("email_cliente1"));
		cliente.setTelefonoCliente(Integer.parseInt(request.getParameter("telefono_cliente1")));
		ejb.actualizarCliente(cliente);
		
		response.sendRedirect("dash_cliente.jsp");
	}

}
