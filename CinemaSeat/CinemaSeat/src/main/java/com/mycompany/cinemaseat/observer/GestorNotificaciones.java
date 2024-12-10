package com.mycompany.cinemaseat.observer;

import com.mycompany.cinemaseat.clases.Usuario;
import java.util.ArrayList;
import java.util.List;

public class GestorNotificaciones {
    private List<Usuario> observadores = new ArrayList<>();

    public void registrarObservador(Usuario usuario) {
        observadores.add(usuario);
    }

    public void eliminarObservador(Usuario usuario) {
        observadores.remove(usuario);
    }

    public void notificarCambio(String mensaje) {
        for (Usuario usuario : observadores) {
            Notificacion notificacion = new Notificacion("Cambio en la función", mensaje, usuario);
            notificacion.enviar();
        }
    }
}