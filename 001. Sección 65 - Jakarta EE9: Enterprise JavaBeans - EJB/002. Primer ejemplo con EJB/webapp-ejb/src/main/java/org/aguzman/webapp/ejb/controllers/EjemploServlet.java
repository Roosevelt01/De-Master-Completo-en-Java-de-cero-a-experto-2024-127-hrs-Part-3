package org.aguzman.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.webapp.ejb.service.ServiceEjb;

import java.io.IOException;

@WebServlet("/index")// Paso 1: Mapea este Servlet a la URL "/index".
public class EjemploServlet extends HttpServlet {

    @EJB // Paso 2: Inyecta el EJB ServiceEjb.
    private ServiceEjb service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException {
    
        // Paso 3: Invoca el método del EJB y guarda el resultado en un atributo de la solicitud.
        req.setAttribute("saludo", service.saludar("andres"));
        // Paso 4: Redirige la solicitud y la respuesta a la vista JSP.
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}