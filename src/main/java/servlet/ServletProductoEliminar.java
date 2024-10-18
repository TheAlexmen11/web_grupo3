package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ejb.EjbGestionProducto;

@WebServlet("/ServletProductoEliminar")
public class ServletProductoEliminar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private EjbGestionProducto ejb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idToDelete"));
        ejb.eliminarProducto(id);
        response.sendRedirect(request.getContextPath() + "/ServletProductoConsultar");
    }
}
