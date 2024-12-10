/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.EstadoAsiento;
import com.mycompany.cinemaseat.EstadoReserva;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Reserva  {

    private Usuario usuario;
    private ArrayList<Asiento> asientosReservados;
    private EstadoReserva estadoReserva;

    public Reserva(Usuario usuario, ArrayList<Asiento> asientosReservados) {
        this.usuario = usuario;
        this.asientosReservados = asientosReservados;
        this.estadoReserva = EstadoReserva.EN_PROCESO;
    }

    public boolean procesarPago() {
        return usuario.confirmarPago(this);
    }

    public void confirmarReserva() {
        for (Asiento asiento : asientosReservados) {
            asiento.cambiarEstado(EstadoAsiento.RESERVADO);
        }
        estadoReserva = EstadoReserva.CONFIRMADA;
    }

    public void cancelarReserva() {
        for (Asiento asiento : asientosReservados) {
            asiento.cambiarEstado(EstadoAsiento.DISPONIBLE);
        }
        estadoReserva = EstadoReserva.CANCELADA;
    }

   
}
