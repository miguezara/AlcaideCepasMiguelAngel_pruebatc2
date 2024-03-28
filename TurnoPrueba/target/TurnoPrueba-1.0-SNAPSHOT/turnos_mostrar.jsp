<%@page import="com.mycompany.turnoprueba.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mostrar Turnos</title>

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">


        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
        <style>
            body {
                background-color: #f8f9fa;
                color: #333;
                font-family: Arial, sans-serif;
            }
            .container {
                margin-top: 50px;
            }
            h1, h3 {
                color: #0056b3;
            }
            .form-control {
                border-color: #0056b3;
            }
            .btn-primary {
                background-color: #0056b3;
                border-color: #0056b3;
            }
            .btn-primary:hover {
                background-color: #004080;
                border-color: #004080;
            }
            .table th, .table td {
                vertical-align: middle;
            }
            .table th {
                background-color: #007bff;
                color: #fff;
            }
            .table-striped tbody tr:nth-of-type(odd) {
                background-color: rgba(0, 123, 255, 0.1);
            }
            .table-hover tbody tr:hover {
                background-color: rgba(0, 123, 255, 0.2);
            }
            .btn-warning {
                background-color: #ffc107;
                border-color: #ffc107;
            }
            .btn-warning:hover {
                background-color: #e0a800;
                border-color: #e0a800;
            }
        </style>
    </head>
    <body>
        <div class="container mt-4">
            <div class="row">
                <div class="col">
                    <form action="TramiteSv" class="p-2 float-right" method="GET" style="display: inline">
                        <button type="submit" class="btn btn-primary">Crear turno</button>
                    </form>
                    <form action="TurnoSv" class="p-2 float-right" method="GET" style="display: inline">
                        <button type="submit" class="btn btn-secondary">Mostrar turnos</button>
                    </form>
                    <a href="index.jsp" class="btn btn-secondary my-2">Inicio</a>
                    <h1 class="mt-4">Gestión de turnos</h1>
                    <h3>Listado de turnos</h3>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <form action="TurnoSv" method="GET">
                        <label for="fecha">Filtrar por fecha:</label>
                        <input type="date" id="fecha" name="fecha" value="<%= (String) request.getAttribute("fecha")%>" required>
                        <button type="submit" name="filtros" value="" class="btn btn-success">Filtrar por fecha</button>

                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col pt-3">
                    <table id="turnos" class="table">
                        <thead>
                            <tr>
                                <th>Número de Turno</th>
                                <th>Nombre Ciudadano</th>
                                <th>DNI</th>
                                <th>Trámite</th>
                                <th>Fecha</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% List<Turno> turnos = (List<Turno>) request.getAttribute("turnos");
                                if (turnos != null && !turnos.isEmpty()) {
                                    for (Turno turno : turnos) {
                            %>
                            <tr>
                                <td><%= turno.getId()%></td>
                                <td><%= turno.getCiudadano().getNombre()%></td>
                                <td><%= turno.getCiudadano().getDni()%></td>
                                <td><%= turno.getTramite().getDescripcion()%></td>
                                <td><%= turno.getFecha()%></td>
                                <td><%= turno.isEstado() ? "En espera" : "Ya atendido"%></td>
                                <td>
                                    <form action="TurnoSv" method="POST">
                                        <input type="hidden" name="action" value="cambiarEstado">
                                        <input type="hidden" name="idTurno" value="<%= turno.getId()%>">
                                        <input type="hidden" name="nuevoEstado" value="<%= !turno.isEstado()%>">
                                        <button type="submit" class="btn btn-warning btn-sm">Cambiar Estado</button>
                                    </form>
                                </td>
                            </tr>
                            <%  }
                            } else {
                            %>
                            <tr>
                                <td colspan="7">No hay turnos disponibles.</td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#turnos').DataTable();
            });
        </script>
    </body>
</html>
