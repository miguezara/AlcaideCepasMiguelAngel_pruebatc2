package com.mycompany.turnoprueba.servlets;

import com.mycompany.turnoprueba.logica.Ciudadano;
import com.mycompany.turnoprueba.logica.Controladora;
import com.mycompany.turnoprueba.logica.Tramite;
import com.mycompany.turnoprueba.logica.Turno;
import com.mycompany.turnoprueba.logica.ValidaDni;
import java.io.IOException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {

    private final Controladora control = new Controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fechaStr = request.getParameter("fecha");
        String filtros = request.getParameter("filtros");
        List<Turno> listaTurnos;

        if (fechaStr != null && !fechaStr.isBlank()) {
            request.setAttribute("fecha", fechaStr);
            LocalDate fecha = LocalDate.parse(fechaStr);
            listaTurnos = aplicarFiltros(fecha, filtros);
        } else {
            listaTurnos = control.traerTurnos();
        }

        request.setAttribute("turnos", listaTurnos);
        request.getRequestDispatcher("turnos_mostrar.jsp").forward(request, response);
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String action = request.getParameter("action");

    if (action != null && action.equals("cambiarEstado")) {
        try {
            long idTurno = Long.parseLong(request.getParameter("idTurno"));
            boolean nuevoEstado = Boolean.parseBoolean(request.getParameter("nuevoEstado"));
            control.cambiarEstado(idTurno, nuevoEstado);
        } catch (NumberFormatException e) {
            // Manejar error de conversión de ID
            manejarError("ID de turno incorrecto", request, response);
            return;
        }
    } else {
        String nombreCiudadano = request.getParameter("nombreCiudadano");
        String dniCiudadano = request.getParameter("dniCiudadano");
        long idTramite = Long.parseLong(request.getParameter("idTramite"));

        // Validar el formato del DNI
        if (!ValidaDni.validarDNI(dniCiudadano)) {
            manejarError("El formato del DNI no es valido.", request, response);
            return;
        }
        // Verificar si el ciudadano ya tiene un turno activo
        if (control.ciudadanoActivo(dniCiudadano, idTramite)) {
            manejarError("El ciudadano ya tiene un turno activo.", request, response);
            return;
        }
        // Buscar ciudadano por DNI en la base de datos
        Optional<Ciudadano> ciudadanoExistente = control.obtenerCiudadanoPorDNI(dniCiudadano);
        if (!ciudadanoExistente.isPresent()) {
            Ciudadano nuevoCiudadano = new Ciudadano(nombreCiudadano, dniCiudadano.toUpperCase());
            control.crearCiudadano(nuevoCiudadano);
            ciudadanoExistente = Optional.of(nuevoCiudadano);
        }
        // Crear un nuevo turno
        Tramite tramite = new Tramite();
        tramite.setId(idTramite);
        Turno turno = new Turno();
        turno.setFecha(LocalDate.now());
        turno.setEstado(true);
        turno.setCiudadano(ciudadanoExistente.get());
        turno.setTramite(tramite);
        control.crearTurno(turno);
        
        
        // Establecer mensaje de éxito
        request.setAttribute("successMessage", "El turno se ha agregado correctamente.");
    }

    // Redirigir a la página de visualización de turnos
    response.sendRedirect(request.getContextPath() + "/TurnoSv");
}



   private List<Turno> aplicarFiltros(LocalDate fecha, String filtros) {
    // Obtener todos los turnos
    List<Turno> turnos = control.traerTurnos();

  
    boolean aplicarFiltroEstado = filtros != null && !filtros.isBlank();

    
    boolean estado = aplicarFiltroEstado ? Boolean.parseBoolean(filtros) : false;

    // Aplicar los filtros utilizando expresiones lambda
    return turnos.stream()
            .filter(turno -> turno.getFecha().equals(fecha))
            .filter(turno -> !aplicarFiltroEstado || turno.isEstado() == estado)
            .collect(Collectors.toList());
}


    private void manejarError(String mensajeError, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tramite> listaTramites = control.obtenerTramites();
        request.setAttribute("listaTramites", listaTramites);
        request.setAttribute("errorTramite", mensajeError);
        request.getRequestDispatcher("turnos.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}