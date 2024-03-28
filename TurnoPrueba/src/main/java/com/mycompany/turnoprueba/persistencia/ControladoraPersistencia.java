package com.mycompany.turnoprueba.persistencia;

import com.mycompany.turnoprueba.logica.Ciudadano;
import com.mycompany.turnoprueba.logica.Tramite;
import com.mycompany.turnoprueba.logica.Turno;
import java.util.List;
import java.util.Optional;

public class ControladoraPersistencia {

    // Instancias de los controladores 
    TurnoJpaController turnoJpa = new TurnoJpaController();
    TramiteJpaController tramiteJPA = new TramiteJpaController();
    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();

    // Método para crear un turno en la base de datos
    public void crearTurno(Turno turno) {
        // Verificar si el turno tiene un ciudadano 
        if (turno.getCiudadano() != null) {
            //  crear el turno
            turnoJpa.create(turno);
        } else {
            // Mmostrar un mensaje de error
            System.err.println("Error: No se puede crear un turno sin ciudadano asociado.");
        }
    }

    // Método para buscar un turno por su ID en la base de datos
    public Optional<Turno> buscarTurnoPorId(Long id) {
        try {

            return Optional.ofNullable(turnoJpa.findTurno(id));
        } catch (Exception e) {

            System.err.println("Error al buscar el turno por ID: " + e.getMessage());
            return Optional.empty();
        }
    }

    // Método para obtener todos los turnos de la base de datos
    public List<Turno> obtenerTurnos() {
        try {

            return turnoJpa.findTurnoEntities();
        } catch (Exception e) {

            System.err.println("Error al obtener los turnos: " + e.getMessage());
            return null;
        }
    }

    // Método para actualizar un turno en la base de datos
    public void actualizarTurno(Turno turno) {
        try {

            turnoJpa.edit(turno);
        } catch (Exception ex) {

            System.err.println("Error al actualizar turno: " + ex.getMessage());
        }
    }

    // Método para crear un trámite en la base de datos
    public void crearTramite(Tramite tramite) {
        try {

            tramiteJPA.create(tramite);
        } catch (Exception e) {

            System.err.println("Error al crear el trámite: " + e.getMessage());
        }
    }

    // Método para obtener todos los trámites de la base de datos
    public List<Tramite> obtenerTramites() {
        try {

            return tramiteJPA.findTramiteEntities();
        } catch (Exception e) {

            System.err.println("Error al obtener los trámites: " + e.getMessage());
            return null;
        }
    }

    // Método para crear un ciudadano en la base de datos
    public void crearCiudadano(Ciudadano ciudadano) {
        try {

            ciudadanoJPA.create(ciudadano);
        } catch (Exception e) {

            System.err.println("Error al crear el ciudadano: " + e.getMessage());
        }
    }

    // Método para buscar un ciudadano por su DNI en la base de datos
    public Optional<Ciudadano> buscarCiudadanoPorDni(String dni) {
        try {

            return ciudadanoJPA.findCiudadanoByDni(dni);
        } catch (Exception e) {
            // Si ocurre un error, imprimir un mensaje de error y devolver Optional vacío
            System.err.println("Error al buscar ciudadano por DNI: " + e.getMessage());
            return Optional.empty();
        }
    }
}
