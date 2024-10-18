package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ejb.EjbGestionComentario;
import web_grupo3jpa.Comentario;

/**
 * Servlet implementation class ServletComentarioRegistrar
 */
 @WebServlet("ServletComentarioRegistro")
public class ServletComentarioRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionComentario ejb;
	
    public ServletComentarioRegistrar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Comentario nuevo = new Comentario();
		nuevo.setNombre(request.getParameter("nombre"));
		nuevo.setCorreo(request.getParameter("correo"));
		nuevo.setTelefono(request.getParameter("telefono"));
		nuevo.setComentario(request.getParameter("comentario"));
		ejb.registrarComentario(nuevo);
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

}
