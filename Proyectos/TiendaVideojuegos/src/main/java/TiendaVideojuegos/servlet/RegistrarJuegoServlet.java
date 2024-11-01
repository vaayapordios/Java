package TiendaVideojuegos.servlet;

import TiendaVideojuegos.dao.LibrosDao;
import TiendaVideojuegos.domain.Libros;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegistrarJuego")
public class RegistrarJuegoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String genero = request.getParameter("genero");

        Libros juego = new Libros(titulo, genero);
        LibrosDao librosDao = new LibrosDao();
        librosDao.addJuego(juego);

        response.sendRedirect("listar_juegos.jsp");
    }
}
