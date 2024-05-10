package Funcio;

import Model.*;
import Utils.Utils;

import java.util.ArrayList;

public class Inici {

    /**
     * Inicia el programa i dona l'opció dels menús
     * @param jugadors Llista de jugadors
     */

    public static void inici(ArrayList<Jugador> jugadors) {
        ArrayList<CartaBrisca> mazo = new ArrayList<>();
        ArrayList<CartaBrisca> taula = new ArrayList<>();
        Crupier crupier = new Crupier(mazo);
        System.out.println("Benvinguts a la brisca");
        System.out.println("Quantitat de Jugadors: ");
        int participants = Utils.demanarValorInt();
        while (true) {
            if (participants == 2 || participants == 4){
                break;
            }
            else{
                System.out.println("2 o 4 jugadors");
                participants = Utils.demanarValorInt();
            }
        }

        for (int i = 0; i < participants; i++) {
            Utils.addJugador(jugadors);
            Mostrar.mostrarJugadors(jugadors);
        }
    boolean sortir = false;
        while (!sortir) {
        int opcio = Utils.demanarValorInt(getMenu());
        Utils.paFuera();
        switch (opcio) {
            case 1:
                if(jugadors.size() == 2 || jugadors.size() == 4) {
                    Partida.partida(jugadors, mazo, taula);
                }
                else{
                    System.out.println("2 o 4 jugadors");
                }
                break;
            case 2:
                if(jugadors.size() > 4) {
                    System.out.println("Recorda que són de 2 o 4 jugadors");
                }
                Utils.addJugador(jugadors);
                Mostrar.mostrarJugadors(jugadors);
                break;
            case 3:
                if (!jugadors.isEmpty()) {
                    Utils.delateJugador(jugadors);
                    Mostrar.mostrarJugadors(jugadors);
                }
                else {
                    System.out.println("Ya no hi ha jugadors");
                    System.out.println("Afegint Jugador...");
                    Utils.addJugador(jugadors);
                    Mostrar.mostrarJugadors(jugadors);
                }
                break;
            case 4:
                if (!jugadors.isEmpty()) {
                    Utils.modifyNom(jugadors);
                    Mostrar.mostrarJugadors(jugadors);
                }
                else {
                    System.out.println("Ya no hi ha jugadors.");
                    System.out.println("Afegint Jugador...");
                    Utils.addJugador(jugadors);
                    Mostrar.mostrarJugadors(jugadors);
                }
                break;
            case 5:
                System.out.println("Moltes gràcies per jugar :)");
                System.exit(0);
        }
    }
}

    /**
     * Mostra el menu
     * @return menu String
     */

    private static String getMenu() {
        return "Quina operació vols realitzar:\n" +
                "  1-Començar Joc\n" +
                "  2-Afegir Jugador\n" +
                "  3-Eliminar Jugador\n" +
                "  4-Modificar Nom\n" +
                "  5-Sortir";
    }
}
