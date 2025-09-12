package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Local;
import org.aguzman.webapp.ejb.models.Producto;

import java.util.List;

@Local
public interface ServiceEjbLocal {
    String saludar(String nombre);
    // Paso 1: Nuevo método para obtener una lista de productos.
    List<Producto> listar();

    // Paso 2: Nuevo método para crear un producto.
    Producto crear(Producto producto);
}
