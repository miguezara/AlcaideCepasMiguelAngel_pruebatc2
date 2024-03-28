<%@page import="java.util.List"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Turno</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            margin-top: 50px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            padding: 30px;
            background-color: #fff;
        }

        .form-control {
            border-radius: 20px;
        }

        .form-label {
            font-weight: bold;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            border-radius: 20px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .btn-block {
            border-radius: 20px;
        }
    </style>
</head>
<body>
    <div class="container my-5">
        <form action="TurnoSv" method="post">
            <!-- Agregamos el campo oculto con el valor de la acción -->
            <input type="hidden" name="action" value="create">
            
            <div class="mb-3">
                <label for="nombreCiudadano" class="form-label">Nombre del ciudadano:</label>
                <input type="text" class="form-control" id="nombreCiudadano" name="nombreCiudadano" required>
            </div>
            <div class="mb-3">
                <label for="dniCiudadano" class="form-label">DNI del ciudadano:</label>
                <input type="text" class="form-control" id="dniCiudadano" name="dniCiudadano" required>
            </div>
            <div class="mb-3">
                <label for="tramiteSelect" class="form-label">Trámite:</label>
                <select class="form-select" id="idTramite" name="idTramite" required>
                    <option selected value="">Seleccione un trámite</option>
                    <% 
                        List<com.mycompany.turnoprueba.logica.Tramite> listaTramites = (List<com.mycompany.turnoprueba.logica.Tramite>) request.getAttribute("listaTramites");
                        for (com.mycompany.turnoprueba.logica.Tramite tramite : listaTramites) {
                    %>
                        <option value="<%= tramite.getId() %>"><%= tramite.getDescripcion() %></option>
                    <% } %>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Crear turno</button>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
