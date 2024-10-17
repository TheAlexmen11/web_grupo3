package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Producto;

import java.io.IOException;
import java.util.List;

import ejb.EjbGestionProducto;

@WebServlet("/ServletProductoConsultar")
public class ServletProductoConsultar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private EjbGestionProducto ejb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> productos = ejb.listarProductos();
        request.setAttribute("productos", productos);
        System.out.println("Número de productos recuperados: " + productos.size());
        request.getRequestDispatcher("/dash_product.jsp").forward(request, response);

    }
    
}
