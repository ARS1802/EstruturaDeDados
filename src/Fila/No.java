package Fila;

public class No {
    private No proximo;
    private No anterior;
    private Dado dado;

    No(Object dado){
        this.dado = new Dado(dado);
    }

    No(Object dado, Prioridade prioridade){
        this.dado = new Dado(dado, prioridade);
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
        return dado.getElemento();
    }

    public Dado getDado(){
        return dado;
    }
}
