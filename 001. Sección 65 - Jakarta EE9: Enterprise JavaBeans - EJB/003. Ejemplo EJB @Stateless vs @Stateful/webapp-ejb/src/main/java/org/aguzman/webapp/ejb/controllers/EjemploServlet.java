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

    @Inject//Paso 1
    private ServiceEjb service;

    @Inject//Paso 2
    private ServiceEjb service2;//Paso 3

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\nService si es igual a service2 = " + service.equals(service2));//Paso 4
        req.setAttribute("saludo", service.saludar("andres"));
        req.setAttribute("saludo2", service2.saludar("john"));//Paso 5
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
