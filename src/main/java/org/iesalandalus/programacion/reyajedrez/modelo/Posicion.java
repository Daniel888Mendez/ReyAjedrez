
package org.iesalandalus.programacion.reyajedrez.modelo;
import java.util.Objects;

public class Posicion {

    private int fila;
    private  char columna;

    //Constructor con parámetro fila columna,
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    //Constructor copia.
    //La línea 22 y 23 no se usan,"o eso creo" pero las dejo por si acaso.
    public Posicion(Posicion posicion){
        if (posicion==null){
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        }
        fila= posicion.getFila();
        columna= posicion.getColumna();
        posicion=new Posicion(getFila(),getColumna());

    }

    public int getFila() {
        return fila;
    }

    private void setFila(int fila) {
        if (fila<1 || fila>8){
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila=fila;
    }

    public char getColumna() {
        return columna;
    }

    private void setColumna(char columna) {
        if (columna>='a' && columna<='h'){
            this.columna = columna;
        }else
            throw new IllegalArgumentException("ERROR: Columna no válida.");
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
    //Practicando el string.format
    public String toString() {
        return String.format("fila=%s, columna=%s",fila, columna);
    }

}
