<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gestión de Turnos</title>

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

        <style>
            /* Estilos para el fondo y el contenedor */
            body {
                background-color: #f0f0f0; /* Color de fondo gris claro */
                margin: 0;
                padding: 0;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .container {
                background-color: #ffffff; /* Color de fondo blanco */
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra suave */
                max-width: 600px;
                width: 100%;
            }

            /* Estilos para el título y los botones */
            .jumbotron-heading {
                color: #008000; /* Color de texto verde */
                font-size: 36px; /* Tamaño del texto */
                margin-bottom: 30px; /* Margen inferior */
            }

            .btn-group {
                margin-top: 20px; /* Margen superior para el grupo de botones */
            }
        </style> 
    </head>
    <body>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Gestión de Turnos </h1>
                <a href="TramiteSv" method="GET" class="btn btn-primary my-2">Crear turno</a>
                <a href="TurnoSv" method="GET"  class="btn btn-secondary my-2">Mostrar turnos</a>
            </div>
        </section>

        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
