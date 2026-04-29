package Fila;

public class No {
    private No proximo;
    private No anterior;
    private Dado elemento;

    No(Object elemento){
        this.elemento = new Dado(elemento);
    }

    No(Object elemento, Prioridade prioridade){
        this.elemento = new Dado(elemento, prioridade);
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento.getData();
    }
}
