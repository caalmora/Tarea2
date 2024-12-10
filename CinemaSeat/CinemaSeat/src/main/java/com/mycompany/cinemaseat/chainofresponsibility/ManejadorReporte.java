package com.mycompany.cinemaseat.chainofresponsibility;

import com.mycompany.cinemaseat.clases.Usuario;
//rweport
public abstract class ManejadorReporte {
        protected ManejadorReporte siguiente;
    
        public void setSiguiente(ManejadorReporte siguiente) {
            this.siguiente = siguiente;
        }
    
        public abstract void manejarReporte(Usuario usuario, String descripcion);
    }

