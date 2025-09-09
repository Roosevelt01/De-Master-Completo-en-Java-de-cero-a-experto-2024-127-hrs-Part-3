package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped//Paso 1
@Stateful//Paso 2
public class ServiceEjb {

        private int contador;//Paso 3

        public String saludar(String nombre){
            contador++;//Paso 4
            System.out.println("\nValor del contado en método saludar " + contador);//Paso 4
            System.out.println("\nImprimiendo dentro del ejb con instancia: "+this);
            return "Hola que tal "+nombre;
        }
}