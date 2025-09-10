package org.aguzman.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.webapp.ejb.service.ServiceEjb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

//    @Inject
//    private ServiceEjb service;
//
//    @Inject
//    private ServiceEjb service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {

        ServiceEjb service = null; // Paso 1: Inicializa las variables para la instancia del EJB.
        ServiceEjb service2 = null; // Paso 2: Inicializa la segunda variable.

        try{
            // Paso 3: Crea una instancia de InitialContext.
            InitialContext ctx = new InitialContext();
            
            // Paso 4: Realiza el lookup para obtener el EJB.
            service = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjb");
            
            // Paso 5: Realiza otro lookup.
            service2 = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjb");
        }catch (NamingException e){
            e.printStackTrace();
        }

        System.out.println("\nService si es igual a service2 = " + service.equals(service2));
        req.setAttribute("saludo", service.saludar("andres"));
        req.setAttribute("saludo2", service2.saludar("john"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

02:47:59,520 INFO  [stdout] (default task-2)
02:47:59,520 INFO  [stdout] (default task-2) Service si es igual a service2 = false
02:47:59,523 INFO  [stdout] (default task-2) Valor del contado en m├®todo saludar 1
02:47:59,524 INFO  [stdout] (default task-2) Imprimiendo dentro del ejb con instancia: org.aguzman.webapp.ejb.service.ServiceEjb@1273347e
02:47:59,526 INFO  [stdout] (default task-2) Valor del contado en m├®todo saludar 1
02:47:59,527 INFO  [stdout] (default task-2) Imprimiendo dentro del ejb con instancia: org.aguzman.webapp.ejb.service.ServiceEjb@36201b1a
