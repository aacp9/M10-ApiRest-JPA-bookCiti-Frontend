<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cl.acabrera.modelDTO.BooksDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<title>Citi Books challenger</title>
</head>
<body>
	<!-- Inicio Header -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="home">Books Citi</a>
	</nav>
	<!-- Fin Header -->
	<div class="p-3">

		<h1>Editar libro</h1>
		<!--  
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary  alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		-->
		<form action="editar" method="post">
			<input type="hidden" name="idBook" value="${VO.getIdBook()}" />
			<table>
				<tr>
					<td class="p-2"><label for="title">Título:</label></td>
					<td><input class="form-control" type="text" name="title"
						id="title" value="${VO.getTitle()}" placeholder="Título" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="author">Autor:</label></td>
					<td><input class="form-control" type="text" id="author"
						value="${VO.getAuthor()}" placeholder="author" name="author" /></td>
				</tr>
				<tr>

					<td class="p-2"><label for="location">Ubicación:</label></td>
					<td>

						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">!</span>
							</div>
							<input type="text" class="form-control"
								value="${VO.getLocation()}" name="location" id="location"
								placeholder="Ubicación">
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" class="btn m-2 btn-success" value="Guardar cambios" /></td>
				</tr>


			</table>
		</form>
	</div>

</body>
</html>
