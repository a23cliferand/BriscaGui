package Funcio;

import Model.*;
import Utils.Utils;
import java.util.ArrayList;

public class Partida {
    /**
     * Inicia la partida
     * @param jugadors Llista de jugadors
     * @param mazo La baralla de cartes
     * @param taula La taula
     */
    public static void partida(ArrayList<Jugador> jugadors, ArrayList<CartaBrisca> mazo, ArrayList<CartaBrisca> taula) {
        mazo.clear();
        CartaBrisca.reserId();
        mazo = Crupier.crearCartes();

        for (int i = 0; i < jugadors.size(); i++) {
            jugadors.get(i).getResto().clear();
            jugadors.get(i).setPuJug(0);
        }
        resetpunts(jugadors);
        Utils.paFuera();

        CartaBrisca paloGordo = Crupier.pillarPalo(mazo);

        Crupier.repartirCartas(mazo, jugadors, 3, paloGordo);

        while (true) {
            prepararTaula(jugadors, taula, paloGordo);
            select(jugadors, taula, paloGordo);
            if (!mazo.isEmpty()) {
                Crupier.repartirCartas(mazo, jugadors, 1, paloGordo);
            } else {
                for (int i = 0; i < jugadors.size(); i++) {
                    if (!jugadors.get(i).getCartera().isEmpty()) {
                        prepararTaula(jugadors, taula, paloGordo);
                        select(jugadors, taula, paloGordo);
                    }
                }
                break;
            }
        }
        Mostrar.mostrarCartasJugadors(jugadors);
        Crupier.fi(jugadors);
        }

    /**
     * Resetea els punts dels jugadors
     * @param jugadors Llista de jugadors
     */

    private static void resetpunts(ArrayList<Jugador> jugadors) {
        for (int i = 0; i < jugadors.size(); i++) {
            jugadors.get(i).setPuJug(0);
        }
    }

    /**
     *
     * @param jugadors Llista de jugadors
     * @param taula La taula
     * @param paloGordo El "palo" més poderós de la partida
     */

    private static void prepararTaula(ArrayList<Jugador> jugadors, ArrayList<CartaBrisca> taula, CartaBrisca paloGordo) {
        for (int i = 0; i < jugadors.size(); i++) {
            Utils.paFuera();
            Mostrar.cartesActuals(jugadors, i);
            System.out.println("Primera carta treta del sistema: " + paloGordo.getNUM() + " de " + paloGordo.getPalo());
            if (!taula.isEmpty()) {
                Mostrar.mostrarTaula(taula);
            }
            if (!jugadors.get(i).getCartera().isEmpty()) {
                ArrayList<CartaBrisca> x = jugadors.get(i).getCartera();
                if (x.size() >= 3) {
                    int uno = x.get(0).getID();
                    int dos = x.get(1).getID();
                    int tres = x.get(2).getID();
                    System.out.println("Introdueix l'ID de la carta que vols utilitzar: ");
                    int pCarta = Utils.demanarValorInt(uno, dos, tres);
                    CartaBrisca pp = null;
                    for (int j = 0; j < jugadors.get(i).getCartera().size(); j++) {
                        Jugador ju = jugadors.get(i);
                        ArrayList<CartaBrisca> cartera = ju.getCartera();
                        if (cartera.get(j).getID() == pCarta) {
                            pp = cartera.get(j);
                        }
                    }
                    taula.add(pp);
                    jugadors.get(i).getCartera().remove(pp);
                } else if (x.size() == 2) {
                    int uno = x.get(0).getID();
                    int dos = x.get(1).getID();
                    System.out.println("Introdueix l'ID de la carta que vols utilitzar: ");
                    int pCarta = Utils.demanarValorInt(uno, dos);
                    CartaBrisca pp = null;
                    for (int j = 0; j < jugadors.get(i).getCartera().size(); j++) {
                        Jugador ju = jugadors.get(i);
                        ArrayList<CartaBrisca> cartera = ju.getCartera();
                        if (cartera.get(j).getID() == pCarta) {
                            pp = cartera.get(j);
                        }
                    }
                    taula.add(pp);
                    jugadors.get(i).getCartera().remove(pp);
                } else if (x.size() == 1) {
                    int uno = x.get(0).getID();
                    System.out.println("Introdueix l'ID de la carta que vols utilitzar: ");
                    int pCarta = Utils.demanarValorInt(uno);
                    CartaBrisca pp = null;
                    for (int j = 0; j < jugadors.get(i).getCartera().size(); j++) {
                        Jugador ju = jugadors.get(i);
                        ArrayList<CartaBrisca> cartera = ju.getCartera();
                        if (cartera.get(j).getID() == pCarta) {
                            pp = cartera.get(j);
                        }
                    }
                    taula.add(pp);
                    jugadors.get(i).getCartera().remove(pp);
                }
            }
        }
    }

    /**
     * El càlcul per poder aconseguir la carta guanyadora
     * @param jugadors Llista de jugadors
     * @param taula La taula
     * @param paloGordo El "palo" més poderós de la partida
     */

    private static void select(ArrayList<Jugador> jugadors, ArrayList<CartaBrisca> taula, CartaBrisca paloGordo) {
        CartaBrisca cartaWin = null;
        int maxValor = -1;
        for (CartaBrisca carta : taula) {
            if (carta.getPalo() == paloGordo.getPalo()) {
                if (carta.getValor() > maxValor) {
                    maxValor = carta.getValor();
                    cartaWin = carta;

                }
            }
        }
        if (cartaWin == null) {
            for (CartaBrisca carta : taula) {
                if (carta.getValor() > maxValor) {
                    maxValor = carta.getValor();
                    cartaWin = carta;
                }
            }
        }

        if (cartaWin.getValor() == 0 && cartaWin.getPalo() != paloGordo.getPalo()) {
            for (CartaBrisca carta : taula) {
                if (carta.getNUM() > maxValor) {
                    maxValor = carta.getValor();
                    cartaWin = carta;
                }
            }
        }

        for (int i = 0; i < taula.size(); i++) {
            if (cartaWin == taula.get(i)) {
                Utils.paFuera();
                System.out.println("----------------");
                System.out.println("Ronda guanyada per " + jugadors.get(i).getNomJug());
                System.out.println("----------------");
                Utils.cotinue();
                Crupier.ganaor(jugadors, i, taula);
            }
        }

        System.out.println("La carta guanyadora es: " + cartaWin.getNUM() + " de " + cartaWin.getPalo());

    }

}
