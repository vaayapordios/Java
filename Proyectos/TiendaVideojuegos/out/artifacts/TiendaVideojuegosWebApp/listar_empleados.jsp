<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listado de Empleados</title>
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
<h1>Listado de Empleados</h1>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
    </tr>
    <c:forEach var="empleado" items="${empleados}">
        <tr>
            <td>${empleado.nombre}</td>
            <td>${empleado.apellidos}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
