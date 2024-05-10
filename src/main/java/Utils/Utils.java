package Utils;
import Funcio.*;
import Model.*;

import java.util.*;

public class Utils {
    /**
     * Esborra de forma "cutre" la terminal (no he trobat una altra manera do fer-lo)
     */

    public static void paFuera() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Espera a l'usuari que premi a l'enter
     */

    public static void cotinue(){
        Scanner input = new Scanner(System.in);
            System.out.println("Pressiona enter per continuar...");
        input.nextLine();
    }

    /**
     * Demana un valor int
     * @return
     */

    public static int demanarValorInt() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Valor incorrecte!!");
            input.next();
        }
        return input.nextInt();
    }

    /**
     * Demana un valor int que siqui igual que el num uno
     * @param uno El num
     * @return El num del usuari
     */

    public static int demanarValorInt(int uno) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        while (num != uno) {
            System.out.println("Valor incorrecte!!");
            num = input.nextInt();
        }
        return num;
    }

    /**
     * Demana un valor int que siqui igual que el num uno o dos
     * @param uno El num uno
     * @param dos El num dos
     * @return El num del usuari
     */

    public static int demanarValorInt(int uno, int dos) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        while (num != uno && num != dos) {
            System.out.println("Valor incorrecte!!");
            num = input.nextInt();
        }
        return num;
    }

    /**
     * Demana un valor int que siqui igual que el num uno, dos o tres
     * @param uno El num uno
     * @param dos El num dos
     * @param tres El num tres
     * @return El num del usuari
     */

    public static int demanarValorInt(int uno, int dos, int tres) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        while (num != uno && num != dos && num != tres) {
            System.out.println("Valor incorrecte!!");
            num = input.nextInt();
        }
        return num;
    }

    /**
     * Demana un valor int i mostra el missatge
     * @param message El missatge
     * @return En num del jugador
     */

    public static int demanarValorInt(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        while (!input.hasNextInt()) {
            System.out.println("Valor incorrecte!!");
            input.next();
        }
        return input.nextInt();
    }

    /**
     * Afeguir jugador
     * @param jugadors Llista de jugadors
     * @return Llista de jugadors
     */

    public static ArrayList<Jugador> addJugador(ArrayList<Jugador> jugadors) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix el nom: ");
        String nom = input.nextLine();
        Jugador jugador = new Jugador(nom, 0, new ArrayList<CartaBrisca>(), new ArrayList<CartaBrisca>());
        jugadors.add(jugador);
        Jugador.ordenarJugadors(jugadors);
        return jugadors;
    }

    /**
     * Esborrar Jugador
     * @param jugadors Llista de jugadors
     * @return Llista de jugadors
     */

    public static ArrayList<Jugador> delateJugador(ArrayList<Jugador> jugadors) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix el nom: ");
        String nom = input.nextLine();
        for (int i = 0; i < jugadors.size(); i++) {
            if (jugadors.get(i).getNomJug().equals(nom)) {
                jugadors.remove(i);
                Jugador.ordenarJugadors(jugadors);
                return jugadors;
            }

        }
        System.out.println("Jugador no trobat");
        return jugadors;
    }

    /**
     * Modificar nom jugador
     * @param jugadors Llista de jugadors
     * @return Llista de jugadors
     */

    public static ArrayList<Jugador> modifyNom(ArrayList<Jugador> jugadors) {
        Scanner input = new Scanner(System.in);
        Mostrar.mostrarJugadors(jugadors);
        System.out.println("Introdueix el nom: ");
        String nom = input.nextLine();
        for (int i = 0; i < jugadors.size(); i++) {
            if (jugadors.get(i).getNomJug().equals(nom)) {
                Mostrar.mostrarJugadors(jugadors, nom);
                System.out.println("Nou nom: ");
                String newnom = input.nextLine();
                jugadors.get(i).setNomJug(newnom);
                return jugadors;
            }
        }
        System.out.println("Jugador no trobat");
        return jugadors;
    }

    /**
     * Ordena per punts els jugadors
     * @param jugadors Llista de jugadors
     * @return Llista de jugadors ordenada
     */
}
