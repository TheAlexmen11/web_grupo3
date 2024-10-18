package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Producto;
import ejb.EjbGestionProducto;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/ServletProductoRegistrar")
public class ServletProductoRegistrar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private EjbGestionProducto ejb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto nuevoProducto = new Producto();
        System.out.println("aqui---> "+request.getParameter("tipo_product"));
        nuevoProducto.setTipoProduct(request.getParameter("tipo_product"));
        nuevoProducto.setMarcaProduct(request.getParameter("marca_product"));
        nuevoProducto.setDescripcion(request.getParameter("descripcion_product"));
        nuevoProducto.setImgProduct(request.getParameter("img_product"));
        nuevoProducto.setPrecio(new BigDecimal(request.getParameter("precio_product")));

        ejb.registrarProducto(nuevoProducto);
        response.sendRedirect(request.getContextPath() + "/ServletProductoConsultar");    }
}