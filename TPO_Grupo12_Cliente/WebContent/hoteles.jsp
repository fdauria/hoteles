<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Oferta Hotelera | Integración de Aplicaciones</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<link rel="stylesheet" href="css/main.css" type="text/css">
	<link rel="stylesheet" href="css/styles.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
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
			<form action="AgregarHotel" method="POST" class="col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-6 col-xs-8 col-sm-6" style="margin:0 auto;">
				<div class="form-group">
					<label for="nombre">Nombre</label>
				    <input type="nombre" class="form-control" id="nombre" name="nombre">
				    <small id="nombrehelp" class="form-text text-muted">Ingrese el nombre del establecimiento</small>
				</div>
				
				<div class="form-group">
					<label for="direccion">Direccion</label>
				    <input type="direccionNombre" class="form-control" id="direccionNombre" name="direccionNombre">
				    <small id="direccionNombre" class="form-text text-muted">Ingrese la direccion</small>
				</div>
				
				<div class="form-group">
					<label for="direccionLatitude">Latitude</label>
				    <input type="direccionLatitude" class="form-control" id="direccionLatitude" name="direccionLatitude">
				</div>
				
				<div class="form-group">
					<label for="direccionLongitud">Longitud</label>
				    <input type="direccionLongitud" class="form-control" id="direccionLongitud" name="direccionLongitud">
				</div>
				
				<div class="form-group">
				    <label for="servicios">Servicios</label>
				    <select id="servicios" class="form-control" multiple data-style="btn-primary" name="servicios">
						<option value="1:Gym">Gym</option>
						<option value="2:Sauna">Sauna</option>
						<option value="3:Pileta">Pileta</option>
						
					</select>
				</div>
				
				<div class="form-group">
				    <label for="mediosDePago">Medios de pago</label>
				    <select id="mediosDePago" class="form-control" multiple data-style="btn-primary" name="mediosDePago">
						<option value="1:VISA">VISA</option>
						<option value="2:MASTER">MASTER</option>
						<option value="3:AMEX">AMEX</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="imagen">Imagen</label>
				    <input id="imagen" type="file" class="file" multiple=true data-preview-file-type="any" name="imagen">
				</div>
				
				<button type="submit" class="btn btn-primary">Agregar hotel</button>
				<a href="./index.jsp" class="">Volver</button>

			</form>
		</div>
	</div>
</body>
</html>