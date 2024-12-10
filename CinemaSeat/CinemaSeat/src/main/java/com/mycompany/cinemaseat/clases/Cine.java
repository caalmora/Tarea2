/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.observer.Notificacion;

import java.util.ArrayList;

/**
 *
 * @author User
 */

public class Cine {
    private String nombre;
    private String ubicacion;
    private ArrayList<Sala> salas;

    public Cine(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.salas = new ArrayList<>();
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public void notificarUsuario(Usuario usuario, Notificacion notificacion) {
        notificacion.enviar();
    }
}

