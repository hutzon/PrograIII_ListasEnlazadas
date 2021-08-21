package prograiii_listasenlazadas;

public class Nodos {

    private int valor;
    private Nodos sig;

    public void Nodos() {
        this.valor = 0;
        this.sig = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodos getSiguiente() {
        return sig;
    }

    public void setSiguiente(Nodos siguiente) {
        this.sig = siguiente;
    }

}
