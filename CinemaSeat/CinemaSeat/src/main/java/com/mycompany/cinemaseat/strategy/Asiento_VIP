package com.mycompany.cinemaseat.strategy;

public class Asiento_VIP implements TipoAsiento {

    private String comodidad;
    private double espacioExtra;
    private double precio;

    public Asiento_VIP(double espacioExtra, String comodidad) {
        this.espacioExtra = espacioExtra;
        this.comodidad = comodidad;
        this.precio = 20.0;
    }

    @Override
    public double calcularPrecio() {
        return precio; 
    }
    
    public double calcularPrecioAdicional() {
        return precio*espacioExtra; 
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
