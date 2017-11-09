<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		
		<h1>Carga de oferta</h1>
		
		<div style="margin-top: 10px; padding-bottom: 40px;"">
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
				<a href="./index.jsp" class="">Volver</button>
				
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

			$('#hotel').change (
	            function() {
	            	$('#habitacion').html("");
	                $.ajax({
	                    type: "POST",
	                    url: "ObtenerHabitacionesPorHotel",
	                    data: {hotel: $('#hotel').attr("selectedIndex") },
	                    success: function(data){
	                    	$('#habitacion').html(data)
	                    }
	                });
	            }
	        );
		
		})
	</script>
	
</body>
</html>