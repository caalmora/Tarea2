package com.mycompany.cinemaseat.chainofresponsibility;

import com.mycompany.cinemaseat.clases.Usuario;

public class AdministradorReporte extends ManejadorReporte {
    @Override
    public void manejarReporte(Usuario usuario, String descripcion) {

            System.out.println("Administrador atendiendo el reporte: " + descripcion);

    }
}
