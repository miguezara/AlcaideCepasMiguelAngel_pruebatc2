package com.mycompany.turnoprueba.logica;

import com.mycompany.turnoprueba.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearTurno(Turno turno) {
        controlPersis.crearTurno(turno);
    }

    public boolean ciudadanoActivo(String dni, long idTramite) {
        return controlPersis.obtenerTurnos().stream()
                .anyMatch(turno -> turno.getCiudadano().getDni().equalsIgnoreCase(dni)
                        && turno.getTramite().getId() == idTramite
                        && turno.isEstado());
    }

    public Optional<Ciudadano> obtenerCiudadanoPorDNI(String dni) {
        return controlPersis.obtenerTurnos().stream()
                .map(Turno::getCiudadano)
                .filter(ciudadano -> ciudadano.getDni().equalsIgnoreCase(dni))
                .findFirst();
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.obtenerTurnos();
    }

    public Optional<Turno> buscarTurnoPorId(Long id) {
        return controlPersis.buscarTurnoPorId(id);
    }

    public void crearTramite(Tramite tramite) {
        controlPersis.crearTramite(tramite);
    }

    public List<Tramite>obtenerTramites() {
        return controlPersis.obtenerTramites();
    }

    

public List<Turno> filtrarFecha(LocalDate fecha) {
    List<Turno> turnos = controlPersis.obtenerTurnos();
    return turnos.stream()
            .filter(turno -> turno.getFecha().equals(fecha))
            .collect(Collectors.toList());
}

public List<Turno> filtrarEstadoYFecha(boolean estado, LocalDate fecha) {
    List<Turno> turnos = controlPersis.obtenerTurnos();
    return turnos.stream()
            .filter(turno -> turno.isEstado() == estado)
            .filter(turno -> turno.getFecha().equals(fecha))
            .collect(Collectors.toList());
}


    public void cambiarEstado(long idTurno, boolean nuevoEstado) {
        controlPersis.buscarTurnoPorId(idTurno).ifPresent(turno -> {
            turno.setEstado(nuevoEstado);
            controlPersis.actualizarTurno(turno);
        });
    }
}

