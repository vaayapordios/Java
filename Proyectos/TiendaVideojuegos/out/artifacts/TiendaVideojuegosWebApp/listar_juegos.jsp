<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listado de Juegos</title>
</head>
<body>
<h1>Listado de Juegos</h1>
<table border="1">
    <tr>
        <th>Título</th>
        <th>Género</th>
        <th>Plataforma</th>
        <th>Precio</th>
    </tr>
    <c:forEach var="juego" items="${juegos}">
        <tr>
            <td>${juego.titulo}</td>
            <td>${juego.genero}</td>
            <td>${juego.plataforma}</td>
            <td>${juego.precio}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
