package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ejb.EjbGestionCliente;
import web_grupo3jpa.Cliente;

@WebServlet("ServletClienteRegistro")
public class ServletClienteRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EjbGestionCliente ejb;
	
    public ServletClienteRegistrar() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("nom_cliente:" + request.getParameter("nom_cliente"));
		System.out.println("dni_cliente:" + request.getParameter("dni_cliente"));
		System.out.println("email_cliente:" + request.getParameter("email_cliente"));
		System.out.println("telefono_cliente:" + request.getParameter("telefono_cliente"));
		// Crear un nuevo cliente
		Cliente nuevo = new Cliente();
		

		nuevo.setNomCliente(request.getParameter("nom_cliente"));
		

		// Convertir dni a Integer
		String dniClienteStr = request.getParameter("dni_cliente");
		if (dniClienteStr != null && !dniClienteStr.isEmpty()) {
		    try {
		        Integer dniCliente = Integer.parseInt(dniClienteStr);
		        nuevo.setDniCliente(dniCliente);
		    } catch (NumberFormatException e) {
		        System.out.println("Error: DNI no es un número válido.");
		        request.setAttribute("error", "DNI no válido. Debe ser un número.");
		        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		        return;
		    }
		} else {
		    System.out.println("Error: DNI está vacío.");
		    request.setAttribute("error", "DNI no puede estar vacío.");
		    request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		    return;
		}

		
		nuevo.setEmailCliente(request.getParameter("email_cliente"));
		
		// Convertir telefono a Integer
		String telefonoClienteStr = request.getParameter("telefono_cliente");
		if (telefonoClienteStr != null && !telefonoClienteStr.isEmpty()) {
		    try {
		        Integer telefonoCliente = Integer.parseInt(telefonoClienteStr);
		        nuevo.setTelefonoCliente(telefonoCliente);
		    } catch (NumberFormatException e) {
		        System.out.println("Error: Teléfono no es un número válido.");
		        request.setAttribute("error", "Teléfono no válido. Debe ser un número.");
		        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		        return;
		    }
		} else {
		    System.out.println("Error: Teléfono está vacío.");
		    request.setAttribute("error", "Teléfono no puede estar vacío.");
		    request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		    return;
		}

		ejb.registrarCliente(nuevo);
		request.getRequestDispatcher("dash_cliente.jsp").forward(request, response);
			}
}
