<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.html" %>
<body>
	<div id="main-container">
		<%@ include file="header.html" %>
		
		<div style="margin-top: 10px;">
			<h2>Seleccione una opcion</h2>
		
			<nav class="navbar navbar-light bg-faded" style="text-align: center">
				<form class="form-inline">
				<a class="col-md-4 col-xs-4 col-sm-4" href="./ListarHoteles">Establecimientos</a> 
					<a class="col-md-4 col-xs-4 col-sm-4" href="./ListarHabitaciones">Habitaciones</a> 
					<a class="col-md-4 col-xs-4 col-sm-4" href="./ListarOfertas">Ofertas</a>
				</form>
			</nav>
		</div>
	</div>
</body>
</html>