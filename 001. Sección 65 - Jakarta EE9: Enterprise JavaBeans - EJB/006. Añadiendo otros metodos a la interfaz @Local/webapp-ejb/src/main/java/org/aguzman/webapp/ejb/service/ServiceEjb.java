package org.aguzman.webapp.ejb.service;

import jakarta.ejb.Stateless;
import org.aguzman.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceEjb implements ServiceEjbLocal {

    private int contador;

    public String saludar(String nombre){
        contador++;
        System.out.println("\nValor del contado en método saludar " + contador);
        System.out.println("\nImprimiendo dentro del ejb con instancia: "+this);
        return "Hola que tal "+nombre;
    }

    // Paso 1: Implementación del método listar().
    @Override
    public List<Producto> listar() {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("peras"));
        productos.add(new Producto("manzanas"));
        productos.add(new Producto("naranjas"));
        return productos;
    }

    // Paso 2: Implementación del método crear().
    @Override
    public Producto crear(Producto producto) {
        System.out.println("Guardando producto..."+producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}