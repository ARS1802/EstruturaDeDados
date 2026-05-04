package Fila;

public class Dado{
    private Object elemento;
    private Prioridade prioridade;

    Dado(Object data){
        this(data,Prioridade.BAIXA);
    }

    Dado(Object data, Prioridade prioridade){
        elemento = data;
        this.prioridade = prioridade;
    }

    public Object getElemento(){
        return elemento;
    }

    public Prioridade getPrioridade(){
        return prioridade;
    }
}
