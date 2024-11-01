<%@ page import="java.util.List" %>
<%@ page import="TiendaVideojuegos.domain.Libros" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listar Libros</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
<h1>Libros Registrados</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Género</th>
    </tr>
    <%
        List<Libros> juegos = (List<Libros>) request.getAttribute("juegos");
        for (Libros juego : juegos) {
    %>
    <tr>
        <td><%= juego.getId() %></td>
        <td><%= juego.getTitulo() %></td>
        <td><%= juego.getGenero() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
