package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Usuario;

import java.io.IOException;

import ejb.EjbGestionUsuario;
@WebServlet("ServletUsuarioActualizar")
public class ServletUsuarioActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private EjbGestionUsuario ejb;
	
    public ServletUsuarioActualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ServletEstudianteRegistro");
		System.out.println("nombre:" + request.getParameter("nom_user1"));
		System.out.println("username:" + request.getParameter("username1"));
		System.out.println("password:" + request.getParameter("password1"));
		System.out.println("rol_user:" + request.getParameter("role_user1"));
		Usuario usuario = ejb.obtenerUsuarioPorId(Integer.parseInt(request.getParameter("user_id1")));
		usuario.setNomUser(request.getParameter("nom_user1"));
		usuario.setUsername(request.getParameter("username1"));
		usuario.setPasswordHash(request.getParameter("password1"));
		usuario.setRolUser(request.getParameter("role_user1"));
		ejb.actualizarUsuario(usuario);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("dash_usuario.jsp");
	}

}
