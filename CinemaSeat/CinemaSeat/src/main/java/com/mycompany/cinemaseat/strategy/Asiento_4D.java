package com.mycompany.cinemaseat.strategy;

import java.util.ArrayList;

public class Asiento_4D implements TipoAsiento {

    private ArrayList<String> efectosEspeciales;
    private double precio;

    public Asiento_4D(ArrayList<String> efectosEspeciales) {
        this.efectosEspeciales = efectosEspeciales;
        this.precio= 15.0;
    }

    public double calcularPrecioAdicional() {
        return precio + (efectosEspeciales.size() * 2.0); 
    }
    
    @Override
    public double calcularPrecio() {
        return precio; 
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
