package TiendaVideojuegos.servlet;

import TiendaVideojuegos.dao.LibrosDao;
import TiendaVideojuegos.domain.Libros;

import TiendaVideojuegos.domain.Libros;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarJuegos")
public class ListarLibrosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibrosDao librosDao = new LibrosDao();
        List<Libros> juegos = librosDao.findAll();

        request.setAttribute("juegos", juegos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar_juegos.jsp");
        dispatcher.forward(request, response);
    }
}
