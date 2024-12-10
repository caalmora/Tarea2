package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.strategy.TipoAsiento;

/**
 *
 * @author User
 */
public class Administrador extends Usuario {

    public Administrador(String nombre, String correo, String tipoUsuario) {
        super(nombre, correo, tipoUsuario);
    }

    public void gestionarPrecios(Cine cine, TipoAsiento tipoAsientoEjemplo, double nuevoPrecio) {
        System.out.println("Actualizando el precio para " + tipoAsientoEjemplo.getClass().getSimpleName() + " a $" + nuevoPrecio);

        // Recorre todas las salas y sus asientos
        for (Sala sala : cine.getSalas()) {
            for (Asiento asiento : sala.getAsientos()) {
                // Si el tipo de asiento coincide, actualiza el precio
                if (asiento.getTipoAsiento().getClass().equals(tipoAsientoEjemplo.getClass())) {
                    asiento.getTipoAsiento().setPrecio(nuevoPrecio);
                }
            }
        }

        System.out.println("Precio actualizado en todos los asientos de tipo " + tipoAsientoEjemplo.getClass().getSimpleName());
    }

    public void agregarSala(Cine cine, Sala sala) {
        cine.agregarSala(sala);
        System.out.println("Sala " + sala + " agregada al cine " + cine);
    }

    public void agregarFuncion(Sala sala, Funcion funcion) {
        sala.agregarFuncion(funcion);
        System.out.println("Función agregada a la sala " + sala);
    }
}
