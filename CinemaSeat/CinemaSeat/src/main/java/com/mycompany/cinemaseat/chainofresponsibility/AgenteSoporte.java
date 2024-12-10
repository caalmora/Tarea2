package com.mycompany.cinemaseat.chainofresponsibility;
import com.mycompany.cinemaseat.clases.Usuario;

public class AgenteSoporte extends ManejadorReporte {
    @Override
    public void manejarReporte(Usuario usuario, String descripcion) {
            System.out.println("Agente de soporte atendiendo el reporte: " + descripcion);
            if (Math.random() > 0.5) {
                System.out.println("Reporte resuelto por el agente de soporte.");
            } else if (siguiente != null) {
                System.out.println("Escalando a administrador...");
                siguiente.manejarReporte(usuario, descripcion);
            }
        }
}
