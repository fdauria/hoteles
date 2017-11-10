<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		
		<h1>Carga de hotel</h1>
		
		<div style="margin-top: 10px; padding-bottom: 40px;">
			<form action="AgregarHotel" enctype="multipart/form-data" method="POST" class="col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-6 col-xs-8 col-sm-6" style="margin:0 auto;">
				<div class="form-group">
					<label for="nombre">Nombre</label>
				    <input type="text" class="form-control" id="nombre" name="nombre">
				    <small id="nombrehelp" class="form-text text-muted">Ingrese el nombre del establecimiento</small>
				</div>
				
				<div class="form-group">
					<label for="direccion">Direccion</label>
				    <input type="text" class="form-control" id="direccionNombre" name="direccionNombre">
				    <small id="direccionNombre" class="form-text text-muted">Ingrese la direccion</small>
				</div>
				
			    <input type="direccionLatitude" class="form-control" id="direccionLatitude" name="direccionLatitude" value="1" style="display:none;">
			    <input type="direccionLongitud" class="form-control" id="direccionLongitud" name="direccionLongitud" value="1" style="display:none;">
			    				
   				<div class="form-group">
				    <label for="servicios">Servicios</label>
				    <select id="servicios" class="form-control" multiple data-style="btn-primary" name="servicios">
					    <c:forEach items="${servicios}" var="servicio">
					    	<option value="${servicio.servicioId}:${servicio.descripcion}">${servicio.descripcion}</option>
						</c:forEach>
					</select>
				</div>				
				
				<div class="form-group">
				    <label for="mediosDePago">Medios de pago</label>
				    <select id="mediosDePago" class="form-control" multiple data-style="btn-primary" name="mediosDePago">
						<c:forEach items="${mediosDePago}" var="medioDePago">
					    	<option value="${medioDePago.medioDePagoId}:${medioDePago.descripcion}">${medioDePago.descripcion}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="imagen">Imagen</label>
				    <input id="imagen" type="file" class="file" data-preview-file-type="any" name="imagen">
				</div>
				
				<button type="submit" class="btn btn-primary">Agregar hotel</button>
				<a href="./index.jsp" class="">Volver</button>

			</form>
		</div>
	</div>
</body>
</html>