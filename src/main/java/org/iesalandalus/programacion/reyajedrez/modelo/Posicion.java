
package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private  char columna;


    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion posicion){
        fila= posicion.getFila();
        columna= posicion.getColumna();
        posicion=new Posicion(getFila(),getColumna());
    }


    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila>=1 && fila<=8){
            this.fila = fila;
        }else
            throw  new IllegalArgumentException("La fila devuelta no es la esperada.");
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna>='a' && columna<='h'){
            this.columna = columna;
        }else
            throw new IllegalArgumentException("La columna devuelta no es la esperada.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return String.format("fila=%s , columna=%s",fila, columna);
    }
}
