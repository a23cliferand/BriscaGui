package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Jugador implements Comparable {
    private String nom;
    private int punts;
    private ArrayList<CartaBrisca> cartera;
    private ArrayList<CartaBrisca> resto;

    public Jugador(String nom, int punts, ArrayList<CartaBrisca> cartera, ArrayList<CartaBrisca> resto) {
        this.nom = nom;
        this.punts = punts;
        this.cartera = cartera;
        this.resto = resto;
    }

    public ArrayList<CartaBrisca> getCartera() {
        return cartera;
    }
    public ArrayList<CartaBrisca> getResto() {
        return resto;
    }

    /**
     * Agafa la quantitat i la puntuació de les cartes de "resto"
     * @return Un array amb les dades de les cartes
     */

    public boolean[][] getQuantitatCartes() {
        ArrayList<CartaBrisca> cartera = this.resto;
        boolean quan[][] = new boolean[12][4];
        // 1 = OROS
        // 2 = BASTOS
        // 3 = ESPADAS
        // 4 = COPAS
        for (int j = 0; j < cartera.size(); j++) {
            String color = String.valueOf(this.resto.get(j).getPalo());
            int NUM = this.resto.get(j).getNUM();
            if (color.equals("OROS")) {
                quan[NUM-1][0] =  true;
            }
            else if (color.equals("BASTOS")) {
                quan[NUM-1][1] =  true;
            }
            else if (color.equals("ESPADAS")) {
                quan[NUM-1][2] =  true;
            }
            else if (color.equals("COPAS")) {
                quan[NUM-1][3] =  true;
            }
        }
        return quan;
    }

    public String getNomJug() {
        return nom;
    }

    public int getPuJug() {
        return punts;
    }

    public void setNomJug(String nom) {
        this.nom = nom;
    }

    public void setPuJug(int punts) {
        this.punts = punts;
    }

    public static ArrayList<Jugador> ordenarJugadors(ArrayList<Jugador> jugadors) {
        Collections.sort(jugadors);
        return jugadors;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Jugador)){
            return -1;
        }
        Jugador e2 = (Jugador) o;
        if (this.getPuJug() > e2.getPuJug()) {
            return -1;
        } else if (this.getPuJug() < e2.getPuJug()) {
            return 1;
        } else {
            return 0;
        }
    }
}
