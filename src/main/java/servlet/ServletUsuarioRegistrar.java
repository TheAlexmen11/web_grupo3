package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ejb.EjbGestionUsuario;
import web_grupo3jpa.Usuario;

@WebServlet("ServletUsuarioRegistro")
public class ServletUsuarioRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EjbGestionUsuario ejb;
	
    public ServletUsuarioRegistrar() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ServletEstudianteRegistro");
		System.out.println("nombre:" + request.getParameter("nom_user"));
		System.out.println("username:" + request.getParameter("username"));
		System.out.println("password:" + request.getParameter("password"));
		System.out.println("rol_user:" + request.getParameter("role_user"));
		Usuario nuevo = new Usuario();
		nuevo.setNomUser(request.getParameter("nom_user"));
		nuevo.setUsername(request.getParameter("username"));
		nuevo.setPasswordHash(request.getParameter("password"));
		nuevo.setRolUser(request.getParameter("role_user"));
		ejb.registrarUsuario(nuevo);
		request.getRequestDispatcher("dash_usuario.jsp").forward(request, response);
	}

}
