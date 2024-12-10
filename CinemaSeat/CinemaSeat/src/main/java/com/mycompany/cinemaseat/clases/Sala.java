/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.EstadoAsiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class Sala {

    private int numeroSala;
    private String tipoSala;
    ArrayList<Asiento> asientos;
    private ArrayList<Funcion> funciones;

    public Sala(int numeroSala, String tipoSala) {
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.asientos = new ArrayList<>();
        this.funciones = new ArrayList<>();
    }
    public Sala(int numeroSala) {
        this.numeroSala = numeroSala;
        this.asientos = new ArrayList<>();
        this.funciones = new ArrayList<>();
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    public void agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
    }

    public Map<Asiento, EstadoAsiento> consultarMapa() {
        Map<Asiento, EstadoAsiento> mapa = new HashMap<>();
        for (Asiento asiento : asientos) {
            mapa.put(asiento, asiento.getEstado());
        }
        return mapa;
    }
    
     public ArrayList<Asiento> getAsientosDisponibles() {
        ArrayList<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientos) {
            if (asiento.getEstado() == EstadoAsiento.DISPONIBLE) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }
}
