package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Producto;

import java.io.IOException;
import java.math.BigDecimal;

import ejb.EjbGestionProducto;

@WebServlet("/ServletProductoActualizar")
public class ServletProductoActualizar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private EjbGestionProducto ejb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto = ejb.consultarPorId(Integer.parseInt(request.getParameter("id_product")));
        
        if (producto != null) {
            producto.setTipoProduct(request.getParameter("tipo_product"));
            producto.setMarcaProduct(request.getParameter("marca_product"));
            producto.setDescripcion(request.getParameter("descripcion_product"));
            producto.setImgProduct(request.getParameter("img_product"));
            producto.setPrecio(new BigDecimal(request.getParameter("precio_product")));

            ejb.actualizarProducto(producto);
            response.sendRedirect("dash_producto.jsp");
        } else {
            response.getWriter().write("Producto no encontrado para actualizar.");
        }
    }
}