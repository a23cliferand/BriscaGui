package Model;

import Funcio.Mostrar;
import Utils.Utils;

import java.util.*;

public class Crupier {
    private ArrayList<CartaBrisca> mazo;

    public Crupier(ArrayList<CartaBrisca> mazo) {
        this.mazo = mazo;
    }

    /**
     * Reparteix les cartes que diquis als jugadors i la primera carta de la partida
     * @param mazo La baralla de cartes
     * @param jugadors Llista de jugadors
     * @param numCartesRepartir quantitat de cartes
     * @param paloGordo El "palo" més poderós de la partida
     */

    public static void repartirCartas(ArrayList<CartaBrisca> mazo, ArrayList<Jugador> jugadors, int numCartesRepartir, CartaBrisca paloGordo) {
        if(mazo.size() < jugadors.size()){
            mazo.add(paloGordo);
        }
        for (Jugador jugador:jugadors ) {
            repartirCartas(mazo, jugador,numCartesRepartir);
        }
    }

    /**
     * Reparteix les cartes que diquis als jugadors
     * @param mazo La baralla de cartes
     * @param numCartesRepartir quantitat de cartes
     */

    public static void repartirCartas(ArrayList<CartaBrisca> mazo, Jugador jugador, int numCartesRepartir) {
        Random rand = new Random();
        if(numCartesRepartir <= mazo.size()) {
            for (int i = 0; i < numCartesRepartir; i++) {
                CartaBrisca carta = mazo.get(rand.nextInt(mazo.size()));
                jugador.getCartera().add(carta);
                mazo.remove(carta);
            }
        }
        else {
            for (int i = 0; i < mazo.size(); i++) {
                CartaBrisca carta = mazo.get(rand.nextInt(mazo.size()));
                jugador.getCartera().add(carta);
                mazo.remove(carta);
            }
        }
    }

    /**
     * Agafar la primera carta per seleccionar el "palo" més poderós
     * @param mazo La baralla de cartes
     * @return El "palo" més poderós de la partida
     */

    public static CartaBrisca pillarPalo(ArrayList<CartaBrisca> mazo) {
        Random rand = new Random();
        CartaBrisca carta = mazo.get(rand.nextInt(mazo.size()));
        CartaBrisca paloGordo = carta;
        mazo.remove(carta);
        System.out.println("Primera carta treta del sistema: " + paloGordo.getNUM() + " de " + paloGordo.getPalo());
        System.out.println("----------------");
        return paloGordo;
    }

    /**
     * Crea la baralla
     * @return La Baralla
     */

    public static ArrayList<CartaBrisca> crearCartes() {
        ArrayList<CartaBrisca> mazo = new ArrayList<CartaBrisca>();
        mazo.clear();
        for (int i = 1; i < 13; i++) {
            if(i != 8){
                if(i != 9){
                    if(i == 1) {
                        mazo.add(new CartaBrisca(Palo.OROS, 11, i));
                        mazo.add(new CartaBrisca(Palo.BASTOS,11, i));
                        mazo.add(new CartaBrisca(Palo.ESPADAS,11, i));
                        mazo.add(new CartaBrisca(Palo.COPAS,11, i));
                    }
                    else if(i == 3) {
                        mazo.add(new CartaBrisca(Palo.OROS,   10, i));
                        mazo.add(new CartaBrisca(Palo.BASTOS,   10, i));
                        mazo.add(new CartaBrisca(Palo.ESPADAS,   10, i));
                        mazo.add(new CartaBrisca(Palo.COPAS,   10, i));
                    }
                    else if(i == 12) {
                        mazo.add(new CartaBrisca(Palo.OROS, 4, i));
                        mazo.add(new CartaBrisca(Palo.BASTOS, 4, i));
                        mazo.add(new CartaBrisca(Palo.ESPADAS, 4, i));
                        mazo.add(new CartaBrisca(Palo.COPAS, 4, i));
                    }
                    else if(i == 11) {
                        mazo.add(new CartaBrisca(Palo.OROS, 3, i));
                        mazo.add(new CartaBrisca(Palo.BASTOS, 3, i));
                        mazo.add(new CartaBrisca(Palo.ESPADAS, 3, i));
                        mazo.add(new CartaBrisca(Palo.COPAS, 3, i));
                    }
                    else if(i == 10) {
                        mazo.add(new CartaBrisca(Palo.OROS, 2, i));
                        mazo.add(new CartaBrisca(Palo.BASTOS, 2, i));
                        mazo.add(new CartaBrisca(Palo.ESPADAS, 2, i));
                        mazo.add(new CartaBrisca(Palo.COPAS, 2, i));
                    }
                    else {
                        mazo.add(new CartaBrisca(Palo.OROS, 0, i));
                        mazo.add(new CartaBrisca(Palo.BASTOS, 0, i));
                        mazo.add(new CartaBrisca(Palo.ESPADAS, 0, i));
                        mazo.add(new CartaBrisca(Palo.COPAS, 0, i));
                    }
                }
            }
        }
        System.out.printf("S'han creat %s cartes%n", mazo.size());
        return mazo;
    }

    /**
     * Li dona les cartes de la taula al jugador
     * @param jugadors Llista de jugadors
     * @param p Posició del jugador a la llista
     * @param taula La taula
     */

    public static void ganaor(ArrayList<Jugador> jugadors, int p, ArrayList<CartaBrisca> taula) {
        for (int i = 0; i < taula.size(); i++) {
            jugadors.get(p).getResto().add(taula.get(i));
        }
        Mostrar.mostrarTaula(taula);
        taula.clear();
    }

    /**
     * Al final de tot, fa el recompte de punts per les cartes de "resto" i diu qui ha guanyat
     * @param jugadors Llista de jugadors
     */

    public static void fi(ArrayList<Jugador> jugadors){;
        for (int i = 0; i < jugadors.size(); i++) {
            int punts2 = 0;
            ArrayList<CartaBrisca> x = jugadors.get(i).getResto();
            for (int j = 0; j < x.size(); j++) {
                punts2 += x.get(j).getValor();
            }
            jugadors.get(i).setPuJug(punts2);
        }
        Jugador.ordenarJugadors(jugadors);
        Utils.paFuera();
        System.out.println("----------------");
        System.out.println("Ha guanyat: " + jugadors.get(0).getNomJug());
        System.out.println("----------------");
        Utils.cotinue();
        Utils.paFuera();
        Mostrar.mostrarJugadors(jugadors);
    }
}
