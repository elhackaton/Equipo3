<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
		<script type="text/javascript" src="js/jquery 2.1.0.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("button").button();
			});

		</script>
		<title>Alta Usuario</title>
	</head>
	<body>
		<h1 style="text-align: center ">Registrarse</h1>
		<table style="border:none; width:220px; margin:0 auto;">
			<tr>
				<td style="width:150px"><label for="usuario">Usuario:</label></td>
				<td style="width:500px">
				<input type="text" name="usuario" placeholder="..."/>
				</td>
			</tr>
			<tr>
				<td style="width:150px"><label for="pass">Contraseña:</label></td>
				<td style="width:500px">
				<input type="password" name="pass" placeholder="..."/>
				</td>
			</tr>
			<tr>
				<td style="width:150px"><label for="repass">Repita Contraseña:</label></td>
				<td style="width:500px">
				<input type="password" name="repass" placeholder="..."/>
				</td>
			</tr>
			<tr>
				<td><label for="email">Correo electronico</label></td>
				<td>
				<input type="text" name="email" placeholder="..."/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
				<button type="button" onclick="parent.jQuery.fancybox.close();">
					Enviar
				</button></td>
			</tr>
		</table>

	</body>
</html>