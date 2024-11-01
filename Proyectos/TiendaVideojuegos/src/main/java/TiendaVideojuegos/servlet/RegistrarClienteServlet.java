package TiendaVideojuegos.servlet;

import TiendaVideojuegos.dao.ClienteDao;
import TiendaVideojuegos.domain.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegistrarCliente")
public class RegistrarClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");

        Cliente cliente = new Cliente(nombre, apellidos);
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.addCliente(cliente);

        response.sendRedirect("listar_clientes.jsp");
    }
}
