package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ejb.EjbGestionUsuario;

@WebServlet("ServletUsuarioEliminar")
public class ServletUsuarioEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionUsuario ejb;
	
    public ServletUsuarioEliminar() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idToDelete"));
		System.out.println(request.getParameter("idToDelete"));
		ejb.eliminarEstudiante(id);
		request.getRequestDispatcher("dash_usuario.jsp").forward(request, response);
	}

}
