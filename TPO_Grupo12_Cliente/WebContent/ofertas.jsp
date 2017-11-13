<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		
		<h1>Carga de oferta</h1>
		
		<div style="margin-top: 10px; padding-bottom: 40px;">
			<form action="AgregarOferta" method="POST" onsubmit="return validationOfertas()" name="ofertasForm" class="col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-6 col-xs-8 col-sm-6" style="margin:0 auto;">
				
				<div class="form-group">
				    <label for="hotel">Hotel</label>
				    <select id="hotel" class="form-control" data-style="btn-primary" name="hotel">
	    				<option value="-1"></option>
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
				    <input type="text" class="form-control" id="precio" name="precio" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
				    <small id="precioHelp" class="form-text text-muted">Ingrese el precio de la oferta</small>
				</div>

				<div class="form-group">
					<label for="cupo">Cupo</label>
				    <input type="text" class="form-control" id="cupo" name="cupo" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
				    <small id="cupoHelp" class="form-text text-muted">Ingrese el cupo</small>
				</div>
				
				<div class="form-group">
					<label for="politicaDeCancelacion">Politicas de cancelacion</label>
					<textarea class="form-control" rows="5" id="politicaDeCancelacion" name="politicaDeCancelacion"></textarea>
				</div>
								
				<button type="submit" class="btn btn-primary" id="BotonOfertas">Agregar Oferta</button>
				<a href="ListarOfertas" class="">Volver</button>
				
			</form>
		</div>
	</div>
	
	<script>
	function formatDate() {
	    var d = new Date(),
	        month = '' + (d.getMonth() + 1),
	        day = '' + d.getDate(),
	        year = d.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    return [month, day,year].join('/');
	}
	</script>
	
	
	<script>
		$(document).ready(function(){
			var date_input=$('input[name="fechaDesde"]');
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
				changeYear : true,
				changeMonth : true,
			})
			
			var date_input=$('input[name="fechaHasta"]');
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
				changeYear : true,
				changeMonth : true,
			})
			

				
					$('#hotel').change(function() {
						$('#habitacion').html("");
						$.ajax({
							type : "POST",
							url : "ObtenerHabitacionesPorHotel",
							data : {
								hotel : $("#hotel").val()
							},
							success : function(data) {
								$('#habitacion').html(data)
							}
						});
					});

				})
	</script>
	
	
		<script>
function validationOfertas() {
	 var hotel = document.forms["ofertasForm"]["hotel"].value;
    if (hotel == null || hotel == "") {
        alert("El campo Hotel no puede estar vacio !!");
        return false;
    }

   var habitacion = document.forms["ofertasForm"]["habitacion"].value;
    if (habitacion == null || habitacion == "") {
        alert("El campo Habitacion no puede estar vacio !!");
        return false;
    }
    var fechaDesde = document.forms["ofertasForm"]["fechaDesde"].value;
    if (fechaDesde == null || fechaDesde == "") {
        alert("El campo FechaDesde no puede estar vacio !!");
        return false;
    }
    
    var fechaHasta = document.forms["ofertasForm"]["fechaHasta"].value;
    if (fechaHasta == null || fechaHasta == "") {
        alert("El campo FechaHasta no puede estar vacio !!");
        return false;
    }
	var fechaActual = new Date(formatDate());
	var fechaD = new Date(fechaDesde);
	var fechaH = new Date(fechaDesde);
	if(fechaActual>fechaD || fechaActual>fechaH){
        alert("Verifique las Fechas ingresadas no pueden ser menor a la Fecha Actual !!");
        return false;
	}
    
    var precio = document.forms["ofertasForm"]["precio"].value;
    if (precio == null || precio == "") {
        alert("El campo Precio no puede estar vacio !!");
        return false;
    }
    var cupo = document.forms["ofertasForm"]["cupo"].value;
    if (cupo == null || cupo == "") {
        alert("El campo Cupo no puede estar vacio !!");
        return false;
    }
    var politicaDeCancelacion = document.forms["ofertasForm"]["politicaDeCancelacion"].value;
    if (politicaDeCancelacion == null || politicaDeCancelacion == "") {
        alert("El campo Politica De Cancelacion no puede estar vacio !!");
        return false;
    }
    
    document.getElementById('BotonOfertas').disabled = 'disabled';

    
    
}
</script>
	
</body>
</html>