package Funcio;

import Model.*;
import Utils.Utils;
import java.util.ArrayList;

public class Mostrar {

    /**
     * Seleccionar els jugadors per després mostrar informació
     * @param jugadors Llista de jugadors
     */

    public static void mostrarJugadors(ArrayList<Jugador> jugadors) {
        System.out.print("----------------------- Jugadors -----------------------");
        System.out.println();
        System.out.printf("%-20s%-20s%n", "Nom", "PTS");
        for (int i = 0; i < jugadors.size(); i++) {
            mostrarInformacioJugador(jugadors.get(i));
        }
        System.out.print("-------------------------------------------------------");
        System.out.println();
    }

    /**
     * Seleccionar un jugador per després mostrar informació
     * @param jugadors Llista de jugadors
     */

    public static void mostrarJugadors(ArrayList<Jugador> jugadors, String nom) {
        System.out.print("----------------------- Jugadors -----------------------");
        System.out.println();
        System.out.printf("%-20s%-20s%n", "Nom", "PTS");
        for (int i = 0; i < jugadors.size(); i++) {
            if (jugadors.get(i).getNomJug().equals(nom)) {
                mostrarInformacioJugador(jugadors.get(i));
            }
        }
        System.out.print("-------------------------------------------------------");
        System.out.println();
    }

    /**
     * Mostrar info del jugador: nom i punts
     * @param j el jugador
     */

    public static void mostrarInformacioJugador(Jugador j) {
        System.out.printf("%-20s%d %s%n", j.getNomJug(), j.getPuJug(), "PTS.");
    }

    /**
     * Mostra el nom del jugador i de les cartes de tots els jugadors
     * @param jugadors Llista de jugadors
     */

    public static void mostrarCartasJugadors(ArrayList<Jugador> jugadors) {
        Utils.paFuera();
        System.out.println("----------------------------------- Resto dels jugadors ---------------------------------");
        for (int i = 0; i < jugadors.size(); i++) {
            System.out.print("---------------------------------------- " + jugadors.get(i).getNomJug() + " ----------------------------------------");
            System.out.println();
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%n"," ","OROS","BASTOS","ESPADAS","COPAS");
            mostrarInformacioCartasJugador(jugadors.get(i));
        }
        System.out.print("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        Utils.cotinue();
    }

    /**
     * Mostra les cartes que te el jugador a la llista "resto"
     * @param j El jugador
     */

    public static void mostrarInformacioCartasJugador(Jugador j) {
        boolean[][]quan = j.getQuantitatCartes();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "1", quan[0][0] ? "X" : "-",quan[0][1]? "X" : "-",quan[0][2]? "X" : "-",quan[0][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "2", quan[1][0]? "X" : "-",quan[1][1]? "X" : "-",quan[1][2]? "X" : "-",quan[1][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "3", quan[2][0]? "X" : "-",quan[2][1]? "X" : "-",quan[2][2]? "X" : "-",quan[2][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "4", quan[3][0]? "X" : "-",quan[3][1]? "X" : "-",quan[3][2]? "X" : "-",quan[3][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "5", quan[4][0]? "X" : "-",quan[4][1]? "X" : "-",quan[4][2]? "X" : "-",quan[4][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "6", quan[5][0]? "X" : "-",quan[5][1]? "X" : "-",quan[5][2]? "X" : "-",quan[5][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "7", quan[6][0]? "X" : "-",quan[6][1]? "X" : "-",quan[6][2]? "X" : "-",quan[6][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "JOTA", quan[9][0]? "X" : "-",quan[9][1]? "X" : "-",quan[9][2]? "X" : "-",quan[9][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "CAVALL", quan[10][0]? "X" : "-",quan[10][1]? "X" : "-",quan[10][2]? "X" : "-",quan[10][3]? "X" : "-");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "REY", quan[11][0]? "X" : "-",quan[11][1]? "X" : "-",quan[11][2]? "X" : "-",quan[11][3]? "X" : "-");
        System.out.println();
    }

    /**
     * Mostra les cartes del jugador en aquell moment de la partida
     * @param jugadors Llista de jugadors
     * @param p Posició del jugador a la llista
     */

    public static void cartesActuals(ArrayList<Jugador> jugadors, int p){
        System.out.println("----------------");
        ArrayList<CartaBrisca> cartera = jugadors.get(p).getCartera();
        System.out.println("Cartes de: " + jugadors.get(p).getNomJug());
        for (int i = 0; i < cartera.size(); i++) {
            System.out.println(cartera.get(i).getID() + " - " + cartera.get(i).getNUM() + " de " + cartera.get(i).getPalo());
        }
        System.out.println("----------------");
    }

    /**
     * Mostra les cartes de la taula en aquell moment de la partida
     * @param taula la taula
     */

    public static void mostrarTaula(ArrayList<CartaBrisca> taula){
        System.out.println("----------------");
        System.out.println("Taula");
        for (int i = 0; i < taula.size(); i++) {
            System.out.println(taula.get(i).getID() + " - " + taula.get(i).getNUM() + " de " + taula.get(i).getPalo());
        }
        System.out.println("----------------");
    }
}
