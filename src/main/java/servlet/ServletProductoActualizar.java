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
            producto.setTipoProduct(request.getParameter("tipo_product_edit"));
            producto.setMarcaProduct(request.getParameter("marca_product_edit"));
            producto.setDescripcion(request.getParameter("descripcion_product_edit"));
            producto.setImgProduct(request.getParameter("img_product_edit"));
            System.out.println("precio producto: "+request.getParameter("tipo_product_edit"));
            System.out.println("precio producto: "+request.getParameter("marca_product_edit"));
            System.out.println("precio producto: "+request.getParameter("descripcion_product_edit"));
            System.out.println("precio producto: "+request.getParameter("img_product_edit"));

            producto.setPrecio(new BigDecimal(request.getParameter("precio_product_edit")));

            ejb.actualizarProducto(producto);
            request.getRequestDispatcher("/dash_product.jsp").forward(request, response);;
        } else {
            response.getWriter().write("Producto no encontrado para actualizar.");
        }
    }
}