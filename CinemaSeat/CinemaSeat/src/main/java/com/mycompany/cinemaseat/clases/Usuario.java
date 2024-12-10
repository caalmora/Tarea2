/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.EstadoAsiento;
import com.mycompany.cinemaseat.observer.Notificacion;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Usuario {

    private String nombre;
    private String correo;
    private String tipoUsuario;
    private ArrayList<Reserva> reservas;

    public Usuario(String nombre, String correo, String tipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public boolean seleccionarAsiento(Funcion funcion, Asiento asiento) {
        if (asiento.getEstado() == EstadoAsiento.DISPONIBLE) {
            asiento.cambiarEstado(EstadoAsiento.EN_PROCESO_COMPRA);
            funcion.actualizarDisponibilidad(asiento, EstadoAsiento.EN_PROCESO_COMPRA);
            return true;
        }
        return false;
    }

    public boolean confirmarPago(Reserva reserva) {
        boolean pagoExitoso = Math.random() > 0.2;
        if (pagoExitoso) {
            System.out.println("Pago confirmado para la reserva de " + nombre);
            reserva.confirmarReserva();
        } else {
            System.out.println("Error en el pago para la reserva de " + nombre);
            Notificacion notificacion = new Notificacion("Pago Fallido", "Hubo un problema con su pago. Por favor, intente de nuevo.", this);
            notificacion.enviar();
        }
        return pagoExitoso;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}
