
package com.mycompany.cinemaseat.observer;

import com.mycompany.cinemaseat.clases.Usuario;

public class Notificacion {
    private String tipoNotificacion;
    private String mensaje;
    private Usuario destinatario;

    public Notificacion(String tipoNotificacion, String mensaje, Usuario destinatario) {
        this.tipoNotificacion = tipoNotificacion;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    public void enviar() {
        System.out.println("Notificación enviada a " + destinatario.getCorreo() + ": " + mensaje);
    }
}

