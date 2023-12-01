package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    //Añadirá color al texto añadiendo esta variable concatenada al texto.
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";


    private Consola (){

    }

    public static void mostrarMenu(){
        System.out.println(ANSI_YELLOW+"""
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!       AJEDREZ DMO 2.0        !!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!                              !!
                !! 1.-Crear Rey por defecto     !!
                !! 2.-Crear Rey eligiendo color !!
                !! 3.-Mover                     !!
                !! 4.-Salir                     !!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                """+ANSI_RESET);

    }

    public static int elegirOpcionMenu () {
        int opcion=0;
        do {
            System.out.println("Elige una opción");
            opcion = Entrada.entero();
        } while (opcion !=1 && opcion !=2 && opcion!=3 && opcion!=4);
        return opcion;
    }

    public static Color elegirColor(){
        int opcionColor;
        System.out.println("""
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!       Elige un Color        !!
                !!  1.-BLANCO       2.-NEGRO   !!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                """);
        do {
            System.out.println("Elige color");
            opcionColor=Entrada.entero();
        }while (opcionColor!=1 && opcionColor!=2);

        if (opcionColor==1){
            return Color.BLANCO;
        }else {
            return Color.NEGRO;
        }

    }

    public static void mostrarMenuDirecciones(){

        System.out.println(ANSI_BLUE+
                """
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!        DIRECCIONES          !!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!                             !!
                !!  1.-NORTE     5.-NORESTE    !!
                !!  2.-SUR       6.-NOROESTE   !!
                !!  3.-ESTE      7.-SURESTE    !!
                !!  4.-OESTE     8.-SUROESTE   !!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !!           ENROQUE           !!
                !!  9.-CORTO     10.-LARGO     !!
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             
                """+ANSI_RESET);

    }

    public static Direccion elegirDireccion(){
        int opcionDireccion;
        Consola.mostrarMenuDirecciones();
        do {
            System.out.println("Elige una Dirección");
            opcionDireccion=Entrada.entero();
        }while (opcionDireccion<1 || opcionDireccion>10);

        switch (opcionDireccion){
            case 1:
                return Direccion.NORTE;
            case 2:
                return Direccion.SUR;
            case 3:
                return Direccion.ESTE;
            case 4:
                return Direccion.OESTE;
            case 5:
                return Direccion.NORESTE;
            case 6:
                return Direccion.NOROESTE;
            case 7:
                return Direccion.SURESTE;
            case 8:
                return Direccion.SUROESTE;
            case 9:
                return Direccion.ENROQUE_CORTO;
            case 10:
                return Direccion.ENROQUE_LARGO;
            default:
        }
        return null;

    }

    public static void despedirse(){
        System.out.println(ANSI_PURPLE + """
				           (0 0)
				------oOO---(_)---oOO------
				|||||||||||||||||||||||||||
				|       Hasta luego       |
				|||||||||||||||||||||||||||
				---------------------------
				          |__|__|
				           || ||
				          ooO Ooo
								""" + ANSI_RESET);
    }


}
