<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Ejemplo</title>
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center; /* Centra horizontalmente */
    align-items: center;     /* Centra verticalmente (opcional) */
    min-height: 100vh;      /* Ocupa toda la altura de la pantalla */
    background-color: #f4f4f4; /* Color de fondo opcional */
}

form {
    width: 80%; /* Ancho del contenedor principal */
    max-width: 800px; /* Ancho máximo para no estirarse demasiado */
    padding: 20px;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Sombra opcional */
    text-align: center; /* Centra el texto dentro del div (títulos, botones) */
}

.input-row {
    display: flex;
    justify-content: space-between; /* Separa los grupos a los extremos */
    margin-top: 1rem;
    width: 100%;
}

.input-group {
    display: flex;
    flex-direction: column; /* Apila label sobre input */
    align-items: flex-start; /* Alinea a la izquierda (opcional) */
}

/* Ajustes para los inputs pequeños */
.input-row input {
    width: auto; /* Ancho según size y maxlength */
    padding: 0.3rem;
    margin-top: 0.3rem; /* Espacio entre label e input */
}

/* Input "Código" alineado a la derecha */
.input-group:last-child {
    align-items: flex-end; /* Alinea el segundo grupo a la derecha */
}

/* Estilo para las etiquetas */
.input-row label {
    font-weight: bold;
}
textarea {
    width: 100%;
    height: 300px; /* Altura fija o ajustable según necesidad */
    margin-top: 20px;
    padding: 10px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-family: Arial, sans-serif;
    resize: vertical; /* Permite redimensionar verticalmente */
}

input[type="text"] {
    width: 48%; /* Para dos inputs lado a lado */
    padding: 8px;
    margin: 5px 1%; /* Espaciado entre inputs */
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="submit"], button {
    padding: 10px 15px;
    margin: 5px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"]:hover, button:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/MiServlet" method="post">
    	<h1>Crear Plantilla</h1>
  	 	<div>
    	    <input type="submit" name="accion" value="Crear">
       	 	<button type="submit" name="accion" value="Informacion">Informacion</button>
        	<input type="submit" name="accion" value="Salir">
    	</div>
    	<div class="input-row">
        <div class="input-group">
            <label for="tipo">Tipo</label>
            <input type="text" id="tipo" name="tipo" maxlength="2">
        </div>
        <div class="input-group">
            <label for="codigo">Código</label>
            <input type="text" id="codigo" name="codigo" maxlength="4">
        </div>
        <div class="input-group">
            <label for="codigo">Asunto</label>
            <input type="text" id="asunto" name="asunto" maxlength="75">
        </div>
    	</div>
    	<textarea name="contenido" placeholder="Escribe aquí..."></textarea>
	</form>
</body>
</html>