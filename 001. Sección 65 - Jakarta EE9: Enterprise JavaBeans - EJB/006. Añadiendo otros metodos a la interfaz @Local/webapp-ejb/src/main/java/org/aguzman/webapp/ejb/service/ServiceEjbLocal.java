package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Local;
import org.aguzman.webapp.ejb.models.Producto;

import java.util.List;

@Local
public interface ServiceEjbLocal {
    String saludar(String nombre);
    List<Producto> listar();//Paso 1
    Producto crear(Producto producto);//Paso 2
}
