package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Local;

@Local // Paso 1: Anotación obligatoria que marca esta interfaz como local.
public interface ServiceEjbLocal {
    String saludar(String nombre); // Paso 2: Define el método de negocio.
}
