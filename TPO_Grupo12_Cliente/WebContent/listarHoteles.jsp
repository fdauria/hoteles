<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		<h1>Lista de hoteles</h1>
		<a class="col-md-4 col-xs-4 col-sm-4" href="./Hoteles">Nuevo hotel</a> 
		
		<a href="./index.jsp" class="">Volver</a>
		
		<table class="table" style="padding: 5px 15px;">
  			<thead class="thead-dark">
	  			<tr>
			      <th scope="col">#Id</th>
			      <th scope="col">Nombre</th>
    			  <th scope="col">Destino</th>
			      <th scope="col">Direccion</th>
			      <th scope="col">Servicios</th>
    			  <th scope="col">Medios de pago</th>
    			  <th scope="col">#IdBO</th>
			    </tr>
			 </thead>
		<tbody>		
			<c:forEach items="${hoteles}" var="hotel">
				<tr>
					<td>${hotel.hotelId}</td>
					<td>${hotel.nombre}</td>
					<td>${hotel.direccion.destino}</td>
					<td>${hotel.direccion.direccion}</td>
					<td>
						<c:forEach items="${hotel.mediosDePago}" var="medioDePago">
							${medioDePago.descripcion},
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${hotel.servicios}" var="servicio">
							${servicio.descripcion},
						</c:forEach>
					</td>
					<td>
						${hotel.backofficeId}
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>