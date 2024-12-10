/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.EstadoAsiento;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class Funcion {

    LocalDateTime horaInicio;
    LocalDateTime horaFin;
    private Map<Asiento, EstadoAsiento> disponibilidadAsientos;

    public Funcion(LocalDateTime horaInicio, LocalDateTime horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidadAsientos = new HashMap<>();
    }

    public Map<Asiento, EstadoAsiento> consultarDisponibilidad() {///mismo a la linea 59
        return disponibilidadAsientos;
    }

    public boolean actualizarDisponibilidad(Asiento asiento, EstadoAsiento estado) {
        if (disponibilidadAsientos.containsKey(asiento)) {
            disponibilidadAsientos.put(asiento, estado);
            return true;
        }
        return false;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setDisponibilidadAsientos(Map<Asiento, EstadoAsiento> disponibilidadAsientos) {
        this.disponibilidadAsientos = disponibilidadAsientos;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public Map<Asiento, EstadoAsiento> getDisponibilidadAsientos() { // mismo a la linea 27
        return disponibilidadAsientos;
    }
}
