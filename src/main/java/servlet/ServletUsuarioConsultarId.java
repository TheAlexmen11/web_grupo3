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

@WebServlet("ServletUsuarioConsultarId")
public class ServletUsuarioConsultarId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionUsuario ejb;
	
    public ServletUsuarioConsultarId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("llego id :"+userId);
		Usuario u = ejb.consultarPorId(userId);
		request.setAttribute("estudianteActual", u);
		response.setContentType("text/plain");
		String userInfo = u.getIdUser()+","+u.getNomUser() + "," + u.getUsername() + "," + u.getPasswordHash()+","+u.getRolUser();
		response.getWriter().write(userInfo);
	}


}
