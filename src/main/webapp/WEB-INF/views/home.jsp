<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- para poder utilizar los atributos de la clase BooksDTO es imperante la siguiente línea -->
<%@page import="cl.acabrera.modelDTO.BooksDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="charset=ISO-8859-1">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css"/>
    <title>Citi Books challenger</title>
    
    	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
    
    
    
</head>
<body>
<!-- Inicio Header -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#">Books Citi</a>
		<div class="navbar">
			<div class="navbar-nav">
			<!--  
				<form action="handleLogout" class="form-inline" method="POST">
					<a class="nav-item nav-link disabled mr-sm-2" href="#"
						tabindex="-1" aria-disabled="true">${usuarioConectado}</a> <input
						type="submit" class="btn btn-outline-danger my-2 my-sm-0"
						name="btnEnviar" value="Cerrar sesión">
				</form>
			-->	
				
			</div>
		</div>
	</nav>
	<!-- Fin Header -->

<!-- Inicio Contenido -->
<div class="p-3">

    <!-- Inicio Mensajes -->
    <c:if test="${mensaje != null ? true : false}">
        <div class="alert alert-secondary alert-dismissible fade show"
             role="alert">${mensaje}
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <!-- Fin Mensajes -->

    <!-- Botón agregar producto -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Menú</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a href="agregarForm" class="btn mr-2 btn-success">Agregar producto</a>
                </li>

<!--
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  
                            Registros por página
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="home?registros=5">5</a>
                            <a class="dropdown-item" href="home?registros=10">10</a>
                            <a class="dropdown-item" href="home?registros=15">15</a>
                        </div>
                    </div>

                </li>
  -->
            </ul>

            <form method="GET" action="home" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" name="busqueda" id="busqueda" type="search" placeholder="Buscar producto">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
            </form>
        </div>
    </nav>
<!--  
    <ul class="pagination pagination-lg justify-content-center m-2">
        <c:forEach items="${paginas}" var="pagina">
            <li class="page-item ${paginaActual == pagina ? 'disabled' : ''}">
                <a class="page-link"
                   href="home?p=${pagina}"
                   tabindex="-1">${pagina}
                </a>
            </li>
        </c:forEach>
    </ul>
-->
    <!-- Inicio Tabla -->
    <table border="1" class="table table-hover">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Título</th>
            <th scope="col">Autor</th>
            <th scope="col">Ubicación</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${VO.books}" var="varTemp">
            <tr>
                <td>${varTemp.getTitle()}</td>
                <td>${varTemp.getAuthor()}</td>
                <td>${varTemp.getLocation()}</td>
                <td>
                    <a href="editarForm?idBook=${varTemp.getIdBook()}" class="btn btn-primary btn-sm">Editar</a>
                    <a href="eliminar?idBook=${varTemp.getIdBook()}" class="btn btn-danger btn-sm">Eliminar</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <!-- Fin tabla -->
</div>

<!-- Fin Contenido -->

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>



</body>
</html>
