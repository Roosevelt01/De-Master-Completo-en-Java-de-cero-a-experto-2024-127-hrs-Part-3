package org.aguzman.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.webapp.ejb.service.ServiceEjb;

import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    @Inject // Paso 1: Se cambia @EJB por @Inject para utilizar el contexto de CDI.
    private ServiceEjb service;

    @Inject // Paso 2: Se inyecta una segunda instancia del mismo EJB.
    private ServiceEjb service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Paso 3: Compara las dos instancias.
        System.out.println("\nService si es igual a service2 = " + service.equals(service2));//Paso 4
        req.setAttribute("saludo", service.saludar("andres"));
        req.setAttribute("saludo2", service2.saludar("john")); // Paso 4: Llama al método del segundo EJB.
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
