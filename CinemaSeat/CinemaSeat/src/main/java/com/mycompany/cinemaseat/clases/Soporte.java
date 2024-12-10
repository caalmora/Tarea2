/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat.clases;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Soporte {

    private ArrayList<Usuario> usuariosReportes;
    
    public Soporte() {
        this.usuariosReportes = new ArrayList<>();
    }

    public void atenderReporte(Usuario usuario) {
        System.out.println("Atendiendo reporte de: " + usuario.getNombre());
    }

    public void escalarProblema(Usuario usuario) {
        System.out.println("Escalando problema para: " + usuario.getNombre());
    }
}
