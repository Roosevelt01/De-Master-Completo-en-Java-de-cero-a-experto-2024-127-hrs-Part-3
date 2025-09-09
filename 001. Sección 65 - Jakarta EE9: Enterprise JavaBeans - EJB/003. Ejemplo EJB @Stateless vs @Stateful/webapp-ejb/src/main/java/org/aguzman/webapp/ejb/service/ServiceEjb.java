package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped // Paso 1: Vincula la instancia del EJB con el ciclo de vida de la solicitud HTTP (Request).
@Stateful // Paso 2: Anotación que indica que este EJB mantendrá una conversación con un cliente.
public class ServiceEjb {

        private int contador; // Paso 3: Agrega un campo de instancia para mantener el estado.

        public String saludar(String nombre){
            contador++; // Paso 4: Incrementa el contador en cada llamada.
            System.out.println("\nValor del contado en método saludar " + contador);
            System.out.println("\nImprimiendo dentro del ejb con instancia: "+this);
            return "Hola que tal "+nombre;
        }
}