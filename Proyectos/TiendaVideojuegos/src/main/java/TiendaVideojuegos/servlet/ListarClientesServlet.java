package TiendaVideojuegos.servlet;

import TiendaVideojuegos.dao.ClienteDao;
import TiendaVideojuegos.domain.Cliente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarClientes")
public class ListarClientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = clienteDao.findAll();

        request.setAttribute("clientes", clientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar_clientes.jsp");
        dispatcher.forward(request, response);
    }
}
