<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		<h1>Lista de habitaciones</h1>
		<a class="col-md-4 col-xs-4 col-sm-4" href="./Habitaciones">Nueva habitacion</a> 
		<a href="./index.jsp" class="">Volver</a>
		
		<table class="table" style="padding: 5px 15px;">
  			<thead class="thead-dark">
	  			<tr>
			      <th scope="col">#Id</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Tipo</th>
			      <th scope="col">Capacidad</th>
    			  <th scope="col">Descripcion</th>
			      <th scope="col">Servicios</th>
			    </tr>
			 </thead>
		<tbody>
    		
			<c:forEach items="${habitaciones}" var="habitacion">
				<tr>
					<td>${habitacion.habitacionId}</td>
					<td>${habitacion.nombre}</td>
					<td>${habitacion.tipo}</td>
					<td>${habitacion.capacidad}</td>
					<td>${habitacion.descripcion}</td>
					<td>
						<c:forEach items="${habitacion.servicios}" var="servicio">
							${servicio.descripcion},
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		
	</div>
</body>
</html>