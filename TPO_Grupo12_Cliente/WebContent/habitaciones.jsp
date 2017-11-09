<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		
		<h1>Carga de habitaciones</h1>
		
		<div style="margin-top: 10px; padding-bottom: 40px;"">
			<form action="AgregarHabitacion" method="POST" class="col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-6 col-xs-8 col-sm-6" style="margin:0 auto;">
				<div class="form-group">
				    <label for="hotel">Hotel</label>
				    <select id="hotel" class="form-control" data-style="btn-primary" name="hotel">
					    <c:forEach items="${hoteles}" var="hotel">
	    					<option value="${hotel.hotelId}">${hotel.nombre}</option>
						</c:forEach>
					</select>
				    <small id="hotelHelp" class="form-text text-muted">Ingrese el hotel que va a tener esta oferta</small>
				</div>

				<div class="form-group">
					<label for="tipo">Tipo</label>
				    <input type="text" class="form-control" id="tipo" name="tipo">
				</div>

				<div class="form-group">
					<label for="capacidad">Capacidad</label>
				    <input type="text" class="form-control" id="capacidad" name="capacidad">
				</div>
				
				<div class="form-group">
					<label for="descripcion">Descripcion</label>
					<textarea class="form-control" rows="5" id="descripcion" name="descripcion"></textarea>
				</div>
				
 				<div class="form-group">
				    <label for="servicios">Servicios</label>
				    <select id="servicios" class="form-control" multiple data-style="btn-primary" name="servicios">
					    <c:forEach items="${servicios}" var="servicio">
					    	<option value="${servicio.servicioId}:${servicio.descripcion}">${servicio.descripcion}</option>
						</c:forEach>
					</select>
				</div>		
				
				<div class="form-group">
					<label for="imagen">Imagen</label>
				    <input id="imagen" type="file" class="file" data-preview-file-type="any" name="imagen">
				</div>
				
				<button type="submit" class="btn btn-primary">Agregar habitacion</button>
				<a href="./index.jsp" class="">Volver</button>

			</form>
		</div>
	</div>
</body>
</html>