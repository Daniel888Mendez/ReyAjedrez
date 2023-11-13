package org.iesalandalus.programacion.reyajedrez.modelo;

public enum Color {
    BLANCO ("Blanco"),
    NEGRO ("Negro");

    private String cadenaAMostrar;

    private Color(String colorRey){
        this.cadenaAMostrar=colorRey;
    }

    @Override
    public String toString() {

        return String.format(cadenaAMostrar);
    }
}