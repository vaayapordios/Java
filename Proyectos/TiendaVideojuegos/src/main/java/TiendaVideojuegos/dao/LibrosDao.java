package TiendaVideojuegos.dao;

import TiendaVideojuegos.domain.Libros;
import TiendaVideojuegos.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrosDao {

    public void addJuego(Libros juego) {
        String sql = "INSERT INTO juegos (titulo, genero) VALUES (?, ?)";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, juego.getTitulo());
            statement.setString(2, juego.getGenero());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libros> findAll() {
        List<Libros> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                Libros juego = new Libros(id, titulo, genero);
                juegos.add(juego);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return juegos;
    }
}
