package Model;

public class CartaBrisca extends Carta {
    private Palo palo;
    private int NUM;
    public static int contadorCartas = 1;

    public CartaBrisca(Palo palo, int valor, int NUM) {
        this.palo = palo;
        this.NUM = NUM;
        this.valor = valor;
        this.ID = contadorCartas;
        contadorCartas += 1;
    }

    public static void reserId() {
        contadorCartas = 1;
    }

    public int getNUM(){
        return this.NUM;
    }

    public Palo getPalo(){
        return this.palo;
    }

    public int getValor(){ return this.valor;}

    public int getID(){ return this.ID;}
}
