package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@Stateless //Probando con stateless y stateful
public class ServiceEjb {

        private int contador;

        public String saludar(String nombre){
            contador++;
            System.out.println("\nValor del contado en método saludar " + contador);
            System.out.println("\nImprimiendo dentro del ejb con instancia: "+this);
            return "Hola que tal "+nombre;
        }
}