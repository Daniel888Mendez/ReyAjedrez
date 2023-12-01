package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Rey;
import javax.naming.OperationNotSupportedException;

public class MainApp {
    private static Rey rey;

    //Color texto
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        int opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);

    }

    private static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1:
                creaReyDefecto();
                mostrarRey();
                break;
            case 2:
                creaReyColor();
                mostrarRey();
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedirse();
                break;
            default:
        }

    }
    private static void creaReyDefecto(){
        rey=new Rey();

    }

    private static void creaReyColor(){
        rey=new Rey(Consola.elegirColor());
    }

    //En este método gestiono las excepciones capturadas previamente en la clase Rey con el método mover.
    //Como también uso el método mostrarRey, este try también captura dicho nullpointer y lo gestiona mostrando en pantalla el error con el println.
    private static void mover()  {
        try {
            mostrarRey();
            rey.mover(Consola.elegirDireccion());
            mostrarRey();

        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println("-"+e.getMessage());
        }

    }

    private static void mostrarRey() {
        if (rey==null){
            throw new NullPointerException("ERROR: El rey es nulo.");
        }
        System.out.println(ANSI_GREEN+ rey +ANSI_RESET);
    }
}
