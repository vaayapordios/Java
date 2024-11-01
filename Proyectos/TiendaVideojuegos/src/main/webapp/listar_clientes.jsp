<%@ page import="TiendaVideojuegos.domain.Cliente" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listar Clientes</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
<h1>Clientes Registrados</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellidos</th>
    </tr>
    <%
        List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
        for (Cliente cliente : clientes) {
    %>
    <tr>
        <td><%= cliente.getId() %></td>
        <td><%= cliente.getNombre() %></td>
        <td><%= cliente.getApellidos() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
