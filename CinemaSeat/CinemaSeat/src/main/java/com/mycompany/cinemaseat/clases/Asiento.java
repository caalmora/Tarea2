package com.mycompany.cinemaseat.clases;

import com.mycompany.cinemaseat.EstadoAsiento;
import com.mycompany.cinemaseat.strategy.TipoAsiento;

public class Asiento {

    private int numero;
    private TipoAsiento tipoAsiento;
    private EstadoAsiento estado;

    public Asiento(int numero, TipoAsiento tipoAsiento) {
        this.numero = numero;
        this.tipoAsiento = tipoAsiento;
        this.estado = EstadoAsiento.DISPONIBLE;
    }

    public int getNumero() {
        return numero;
    }

    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoAsiento nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public double obtenerPrecio() {
        return tipoAsiento.calcularPrecio();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipoAsiento(TipoAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    public void setPrecio(double precio) {
        tipoAsiento.setPrecio(precio);  
    }
}
