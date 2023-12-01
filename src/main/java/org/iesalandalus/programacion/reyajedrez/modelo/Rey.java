package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos = 0;

/*constructor por defecto; sin ningún parámetro,
 pondrá el atributo de la clase rey,
 gracias al setColor y posición en color blanco y posición 1e*/

    public Rey() {
        setColor(Color.BLANCO);
        setPosicion(new Posicion(1, 'e'));
    }

//Constructor con parámetro color de la clase Color
    public Rey(Color color) {
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        if (color == Color.BLANCO) {
            setPosicion(new Posicion(1, 'e'));
            this.color = color;
        }
        if (color == Color.NEGRO) {
            setPosicion(new Posicion(8, 'e'));
            this.color = color;
        }

    }

    public Posicion getPosicion() {
        return posicion;
    }

    private void setPosicion(Posicion posicion) {
        if (posicion == null) {
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

        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }

        if (direccion == Direccion.ENROQUE_CORTO) {
            comprobarEnroque();
            setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 2)));
            totalMovimientos++;
        }

        if (direccion == Direccion.ENROQUE_LARGO) {
            comprobarEnroque();
            setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 2)));
            totalMovimientos++;
        }

        //Este try atrapará cualquier error de IllegalargumenException y lo lanza como operation con un mensaje personalizado.
        //Exactamente, capturará los ilegals del los métodos setPosicion de Posicion.
        //Esto solo lo atrapará y lo lanza para que otro método lo gestione, la próxima vez que usemos este método lo tendremos que gestionar o seguir lanzándolo para que lo gestione en otra parte.
        try {
            switch (direccion) {
                case NORTE:
                    setPosicion(new Posicion(posicion.getFila() + 1, posicion.getColumna()));
                    totalMovimientos++;
                    break;
                case SUR:
                    setPosicion(new Posicion(posicion.getFila() - 1, posicion.getColumna()));
                    totalMovimientos++;
                    break;
                case ESTE:
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 1)));
                    totalMovimientos++;
                    break;
                case OESTE:
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 1)));
                    totalMovimientos++;
                    break;
                case NORESTE:
                    setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1)));
                    totalMovimientos++;
                    break;
                case NOROESTE:
                    setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 1)));
                    totalMovimientos++;
                    break;
                case SURESTE:
                    setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 1)));
                    totalMovimientos++;
                    break;
                case SUROESTE:
                    setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 1)));
                    totalMovimientos++;
                    break;
            }

        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        }

    }


    //Este método primero comprueba si está en la posición inicial y si nó, lanzará la excepción.
    //El segundo if lanza excepción solo si está en su posición inicial, pero ya se ha movido con anterioridad.
    private void comprobarEnroque() throws OperationNotSupportedException {

        if ((posicion.equals(new Posicion(1,'e'))) || (posicion.equals(new Posicion(8,'e')))) {
            if (totalMovimientos>0){
                throw new OperationNotSupportedException("ERROR: El rey ya se ha movido antes.");
            }

        } else {
            throw new OperationNotSupportedException("ERROR: El rey no está en su posición inicial.");
        }

    }

    @Override
    //Practicando el string.format
    public String toString () {
        return String.format("color=%s, posicion=(%s)", color, posicion);
    }

}
