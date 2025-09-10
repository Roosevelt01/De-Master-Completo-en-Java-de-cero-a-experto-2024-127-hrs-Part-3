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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjb service = null;//Paso 1
        ServiceEjb service2 = null;//Paso 2

        try{
            InitialContext ctx = new InitialContext();//Paso 3
            service = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjb");//Paso 4
            service2 = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjb"); //Paso 5
        }catch (NamingException e){
            e.printStackTrace();
        }

        System.out.println("\nService si es igual a service2 = " + service.equals(service2));
        req.setAttribute("saludo", service.saludar("andres"));
        req.setAttribute("saludo2", service2.saludar("john"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
