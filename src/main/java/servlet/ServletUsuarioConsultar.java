package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Usuario;

import java.io.IOException;
import java.util.List;

import ejb.EjbGestionUsuario;

@WebServlet("ServletUsuarioConsultar")
public class ServletUsuarioConsultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionUsuario ejb;
     
    public ServletUsuarioConsultar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = ejb.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/dash_usuario.jsp").forward(request, response);
	}


}
