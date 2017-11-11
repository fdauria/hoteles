<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		<h1>Lista de ofertas</h1>
		<a class="col-md-4 col-xs-4 col-sm-4" href="./Ofertas">Nueva oferta</a> 
		<a href="./index.jsp" class="">Volver</a>
		
		<table class="table" style="padding: 5px 15px;">
  			<thead class="thead-dark">
	  			<tr>
			      <th scope="col">#Id</th>
			      <th scope="col">Fecha desde</th>
			      <th scope="col">Fecha hasta</th>
   			      <th scope="col">Cupo</th>
			      <th scope="col">Precio</th>
    			  <th scope="col">Habitacion</th>
		      	  <th scope="col">Hotel</th>
			      <th scope="col">Politicas de cancelacion</th>
			    </tr>
			 </thead>
		<tbody>
    		
			<c:forEach items="${ofertas}" var="oferta">
				<tr>
					<td>${oferta.ofertaId}</td>
					<td>${oferta.fechaDesde}</td>
					<td>${oferta.fechaHasta}</td>
					<td>${oferta.cupo}</td>
					<td>${oferta.precio}</td>
					<td>${oferta.habitacion.nombre}</td>
					<td>${oferta.hotel.nombre}</td>
					<td>${oferta.politicaCancelacion}</td>
				</tr>
			</c:forEach>
		</table>
		
		
	</div>
</body>
</html>