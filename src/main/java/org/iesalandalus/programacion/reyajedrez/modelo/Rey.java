package org.iesalandalus.programacion.reyajedrez.modelo;

public class Rey {
    Color color;
    Posicion posicion;
    private int totalMovimientos;

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if (color==Color.NEGRO || color==Color.BLANCO){
            this.color=color;
        }else
            throw new IllegalArgumentException("Error:El color es erroneo");

    }

    public Posicion getPosicion() {
        return posicion;
    }




}
