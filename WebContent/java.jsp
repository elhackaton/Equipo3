<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

		<link rel="stylesheet" href="css/pag_arbol.css">
		<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
		<link rel="stylesheet" href="fancybox/source/jquery.fancybox.css">
		<link rel="stylesheet" href="fancybox/source/helpers/jquery.fancybox-buttons.css">

		<script type="text/javascript" src="js/jquery 2.1.0.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>
		<script type="text/javascript" src="fancybox/source/jquery.fancybox.pack.js"></script>
		<script type="text/javascript" src="fancybox/source/helpers/jquery.fancybox-buttons.js"></script>

		<script type="text/javascript">
			jQuery(document).ready(function() {				
					$.fancybox({
						href : "multimedia/multimedia.html",
						type : "iframe",
						autoScale : false,
						autoSize : false,
						width : 660,
						height : 500
					});
					$("#bucles").click(function() {
						$.fancybox({
							href : "ejercicio.html",
							type : "iframe",
							autoScale : false,
							autoSize : false,
							width : 510,
							height : 312,
							padding :0
						});
					});
						
			});

		</script>
		

		

		<title>Aprenda Java</title>
	</head>
	<body>
		<header>
			<h1 type="text-align:center">ARBOL DE CONTENIDOS</h1>
			<table>
				<tr>
					<form id = "formulario">
					<td><label for="buscar"></label></td>
					<td><input id="buscador" type="text" placeholder="Busca contenidos"></td>
					<td><input id="btnBuscar" type="button" value="Buscar"/></td>
</form>
				</tr>
			</table>
		</header>
		<section id="temas">
			<a href="#">
				<article id="variables" class="hover" style="height:148px;top:20px">
					<h1>Definicion de Variables</h1>
					<ol>
						<li>Nombres de variables</li>
						<li>Tipos primitivos</li>
						<li>Definir e inicializar</li>
						<li>Visibilidad y vida de las variables</li>
					</ol>
				</article>
			</a>
			<a href="#">
				<article id="operadores" class="medio hover">
					<h1>Tipos de operadores</h1>
					<ol>
						<li>Operadores aritmeticos</li>
						<li>Operadores de asignacion</li>
						<li>Operadores logicos</li>
						<li>Operadores relacionales</li>
					</ol>
				</article>
			</a>
			<a href="#">
				<article id="if_else" class="hover">
					<h1>Estructuras if else</h1>
					<ol>
						<li>Bifurcacion if</li>
						<li>Bifurcacion if else</li>
						<li>Bifurcacion if elseif else</li>
						<li>Sentencia switch</li>
					</ol>
				</article>
			</a>
			<a href="#">
				<article id="bucles" class="hover">
					<h1>Estructuras for</h1>
					<ol>
						<li>Declaracion</li>
						<li>Bucles infinitos</li>
						<li>Bucles anidados</li>
						<li>Sentencia break</li>
					</ol>
				</article>
			</a>
			<a href="#">
				<article id="metodos" class="medio hover">
					<h1>Metodos</h1>
					<ol>
						<li>Declaracion</li>
						<li>Paso de argumentos</li>
						<li>Metodos constructores</li>
						<li>Metodos inicializadores</li>
					</ol>
				</article>
			</a>
			<a href="#">
				<article id="flecha">
					<img src="images/flecha_derecha.png" alt="icono avanzar en el árbol" title="Siguiente grupo de temas" class="hover"/>
				</article>
			</a>
		</section>
		
		<div id="ejercicios">
			<article id="ejercicios_variables">
				<h1 style="text-align: center">Ejercicios</h1>
				<ol>
					<li>Nombres de variables</li>
					<li>Tipos primitivos de variables</li>
					<li>Como se definen e inicializan las variables</li>
					<li>Visibilidad y vida de las variables</li>
					<li>Casos especiales: Clases BigInteger y BigDecimal</li>
				</ol>
			</article>
		<div><h1>Recomendaciones</h1>	</div>
		<div> 
</div>" </div>
		</div>
	</body>
</html>