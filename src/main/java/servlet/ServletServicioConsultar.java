package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import dto.ServicioDTO;
import ejb.EjbGestionServicio;

@WebServlet("ServletServicioConsultar")
public class ServletServicioConsultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EjbGestionServicio ejb;
	
    public ServletServicioConsultar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ServicioDTO> infoServicios = ejb.obtenerInformacionServicio();
		System.out.println(infoServicios);
        request.setAttribute("infoServicios", infoServicios);
        request.getRequestDispatcher("/dash_servicio.jsp").forward(request, response);
	}



}
