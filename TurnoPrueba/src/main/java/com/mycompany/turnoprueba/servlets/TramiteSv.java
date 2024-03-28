package com.mycompany.turnoprueba.servlets;

import com.mycompany.turnoprueba.logica.Controladora;
import com.mycompany.turnoprueba.logica.Tramite;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TramiteSv", urlPatterns = {"/TramiteSv"})
public class TramiteSv extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Obtenemos la lista de los tramites            
            List<Tramite> listaTramites = control.obtenerTramites();

            // Si la lista de tramites está vacía, creamos los tramites predeterminados
            if (listaTramites == null || listaTramites.isEmpty()) {
                // Lista de nombres de tramites predeterminados
                List<String> nombresTramites = Arrays.asList(
                        "Solicitud Renovacion  DNI",
                        "Solicitud Cita ITV",
                        "Solicitud Cita Medica",
                        "Solicitud Examen Final",
                        "Solicitud Registro Nacimiento",
                        "Solicitud Registro Matrimonio",
                        "Solicitud Ayuda Subvenciones"
                );

                // Crear los tramites
                for (String nombreTramite : nombresTramites) {
                    control.crearTramite(new Tramite(nombreTramite));
                }

                // Actualizar la lista de tramites
                listaTramites = control.obtenerTramites();
            }

            request.setAttribute("listaTramites", listaTramites);

            request.getRequestDispatcher("turnos.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error al inicializar datos: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
