package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Stateless;

@Stateless// Paso 1: Anotación obligatoria para marcar la clase como un EJB sin estado.
public class ServiceEjb {

        public String saludar(String nombre){
            // Paso 2: Un método simple que contiene la lógica de negocio.
            System.out.println("Imprimiendo dentro del ejb con instancia: "+this);
            return "Hola que tal "+nombre;
        }
}

