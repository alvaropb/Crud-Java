<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
</head>
<body>
<h1>Listar Productos</h1>
	<table border="1">
		<tr>
			<td>id</td>
			<td>Nombre</td>
			<td>id_usuario</td>
		</tr>
		<c:forEach var="producto" items="${lista}">
			<tr>
				<td> <a href="productos?opcion=meditar&id=<c:out value="${producto.id}"></c:out>"><c:out value="${producto.id}"></c:out></a> </td>
				<td><c:out value="${producto.nombre}"></c:out> </td>
				<td><c:out value="${producto.idUsuario }"></c:out>  </td>
				<td><a href="productos?opcion=eliminar&id=<c:out value="${producto.id}"></c:out>">Eliminar</a>  </td>
			</tr>
		</c:forEach>

	</table>	
</body>
</html>