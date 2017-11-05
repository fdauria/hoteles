<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>Oferta Hotelera | Integración de Aplicaciones</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<link rel="stylesheet" href="css/main.css" type="text/css">
	<link rel="stylesheet" href="css/styles.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body>
	<div id="main-container">
		<header style="text-align:center;">
		  <h1>
		    OFERTA<span> HOTELERA</span>
		  </h1>
		  <h4>Grupo 12</h4>
		  <p>Cah - D'Auria - De Los Santos - Perata - Vommaro</p>
		</header>
		
		<div style="margin-top: 10px;">
			<form action="AgregarOferta" method="POST" class="col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-6 col-xs-8 col-sm-6" style="margin:0 auto;">
				
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
				    <label for="habitacion">Habitacion</label>
				    <select id=habitacion class="form-control" data-style="btn-primary" name="habitacion">
						<option value="1">Habitacion1</option>
						<option value="2">Habitacion2</option>
						<option value="3">Habitacion3</option>
					</select>
				    <small id="habitacionHelp" class="form-text text-muted">Ingrese la habitacion que va a tener esta oferta</small>
				</div>
				
				<div class="form-group">
					<label for="fechaDesde">Fecha desde</label>
				    <input type="text" class="form-control" id="fechaDesde" name="fechaDesde" placeholder="MM/DD/YYYY">
				</div>
				
				<div class="form-group">
					<label for="fechaHasta">Fecha hasta</label>
				    <input type="text" class="form-control" id="fechaHasta" name="fechaHasta" placeholder="MM/DD/YYYY">
				</div>
				
				<div class="form-group">
					<label for="precio">Precio</label>
				    <input type="precio" class="form-control" id="precio" name="precio">
				    <small id="precioHelp" class="form-text text-muted">Ingrese el precio de la oferta</small>
				</div>
				
				<div class="form-group">
					<label for="politicaDeCancelacion">Politicas de cancelacion</label>
					<textarea class="form-control" rows="5" id="politicaDeCancelacion" name="politicaDeCancelacion"></textarea>
				</div>
								
				<button type="submit" class="btn btn-primary">Agregar Oferta</button>
				<a href="./index.jsp" class="btn btn-primary">Volver</button>
				
			</form>
		</div>
	</div>
	
	
	<script>
		$(document).ready(function(){
			var date_input=$('input[name="fechaDesde"]');
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
			})
			
			var date_input=$('input[name="fechaHasta"]');
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
			})
		})
	</script>
	
</body>
</html>