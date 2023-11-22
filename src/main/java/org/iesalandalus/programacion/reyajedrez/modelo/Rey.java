package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos=0;

/*constructor por defecto; sin ningun parametro,
 pondra el atributo de la clase rey ,
 gracias al setColor en color blanco previamente definido,
 como un enum de la clase color y en la posicion 1e*/

    public Rey() {
        setColor(Color.BLANCO);
        setPosicion(new Posicion(1,'e'));
    }

/* Constructor con parametro color de la clase Color
* si la condicion es BLANCO creara un nuevo objeto possicion
* usando el constructor de la clase posicion que tiene dos parametros(fila,columna)*/

    public Rey(Color color) {
        if(color==Color.BLANCO){
            setPosicion(new Posicion(1,'e'));
        }
        if(color==Color.NEGRO){
            setPosicion(new Posicion(8,'e'));
        }
        if (color==null){
            throw new NullPointerException("Error. el color no puede ser nulo.");
        }
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if (color == null){
            throw new NullPointerException("Error.El color no puede ser nulo.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    private void setPosicion(Posicion posicion) {
        if(posicion==null){
            throw new NullPointerException("Error la posicion no puede ser nula.");
        }
        this.posicion = posicion;
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) {
        this.totalMovimientos = totalMovimientos;
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion==null){
            throw  new NullPointerException("ERROR.La direccion no puede ser nula");
        }
        if (direccion==Direccion.ENROQUE_CORTO && totalMovimientos>0){
            throw new OperationNotSupportedException("ERROR.No se puede hacer enrroque corto si ya se ha movido el rey");
        }
        if (direccion==Direccion.ENROQUE_LARGO && totalMovimientos>0){
            throw new OperationNotSupportedException("ERROR.No se puede hacer enrroque largo si ya se ha movido el rey");
        }

        switch (direccion){
            case SUR ->
                getPosicion();
        }


    }









}
