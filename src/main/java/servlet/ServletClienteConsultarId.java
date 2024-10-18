package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_grupo3jpa.Cliente;

import java.io.IOException;

import ejb.EjbGestionCliente;

@WebServlet("/ServletClienteConsultarId")
public class ServletClienteConsultarId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private EjbGestionCliente ejb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clienteId = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = ejb.consultarPorId(clienteId);
        
        if (cliente != null) {
            request.setAttribute("productoActual", cliente);
            response.setContentType("text/plain");
            String clienteInfo = cliente.getIdCliente() + "," + cliente.getNomCliente() + "," + cliente.getDniCliente() + "," + cliente.getEmailCliente() + "," + cliente.getTelefonoCliente() ;
            response.getWriter().write(clienteInfo);
        } else {
            response.getWriter().write("Producto no encontrado.");
        }
    }
}