package Fila;

public class FilaDinamica {
    No inicio, fim;
    int size = 0;

    public FilaDinamica(Object... elementos){
        inicio = new No(elementos[0]);
        No aux = inicio;
        for(int i = 1; i < elementos.length; i++){
            No novo = new No(elementos[i]);
            aux.setProximo(novo);
            novo.setAnterior(aux);
            aux = novo;
        }
        fim = aux;
        size = elementos.length;
    }

    public void enqueue(Object elemento) throws Exception{
        if(isEmpty()){
            inicio = new No(elemento);
            size++;
        } else{
            No novo = new No(elemento);
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
            size++;
        }
    };

    public Object dequeue() throws Exception{
        if(size<=1){
            inicio = fim = null;
            size--;
            return null;
        }

        No aux = inicio.getProximo();
        aux.setAnterior(null);
        inicio = aux;
        size--;
        return peekInicio();
    };

    public Object peekInicio() throws Exception{
        return inicio.getElemento();
    };

    public Object peekFim() throws Exception{
        return fim.getElemento();
    };

    public void clear()throws Exception{
        inicio = null;
        fim = null;
        size = 0;
    };

    public boolean isEmpty() throws Exception{
        return (inicio == null && fim == null) || (size<=0);
    };

    public boolean contains(Object elemento) throws Exception{
        if(isEmpty()){return false;};
        No aux = inicio;
        while(aux != null){
            if(aux.getElemento().equals(elemento)){
                return true;
            } else{
                aux = aux.getProximo();
            }
        }
        return false;
    };

    public int size() throws Exception{
        return size;
    };

    @Override
    public String toString(){
        No aux = inicio;
        StringBuilder s = new StringBuilder();
        while(aux != null){
            s.append(aux.getElemento());
            aux = aux.getProximo();
            if(aux != null){ s.append(", "); }
        }
        return s.toString();
    }
}
