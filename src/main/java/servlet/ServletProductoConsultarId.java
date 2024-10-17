package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Producto;

import java.io.IOException;

import ejb.EjbGestionProducto;

@WebServlet("/ServletProductoConsultarId")
public class ServletProductoConsultarId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private EjbGestionProducto ejb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productoId = Integer.parseInt(request.getParameter("id"));
        Producto producto = ejb.consultarPorId(productoId);
        
        if (producto != null) {
            request.setAttribute("productoActual", producto);
            response.setContentType("text/plain");
            String productoInfo = producto.getIdProduct() + "," + producto.getTipoProduct() + "," + producto.getMarcaProduct() + "," + producto.getDescripcion() + "," + producto.getImgProduct() + "," + producto.getPrecio();
            response.getWriter().write(productoInfo);
        } else {
            response.getWriter().write("Producto no encontrado.");
        }
    }
}