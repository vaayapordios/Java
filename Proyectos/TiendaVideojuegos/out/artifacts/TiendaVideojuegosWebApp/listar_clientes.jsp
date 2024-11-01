<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listado de Clientes</title>
</head>
<body>
<h1>Listado de Clientes</h1>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Email</th>
    </tr>
    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.nombre}</td>
            <td>${cliente.apellidos}</td>
            <td>${cliente.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
