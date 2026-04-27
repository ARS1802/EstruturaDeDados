package Fila;

public enum Prioridade {
    ALTA(0),MEDIA(1),BAIXA(2);
    private int valor;
    Prioridade(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
}
