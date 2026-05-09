package Fila;
public class FilaOrdenada {
    No inicio, fim;
    int size = 0;

    public FilaOrdenada(int[] elementos) throws Exception{
        for(int i = 0; i < elementos.length; i++){
            enqueue(elementos[i]);
        }
    }

    public void enqueue(Object elemento) throws Exception{
        No novo = new No(elemento);
        int elementoNovo = (int) elemento;

        if(isEmpty()){
            inicio = novo;
            fim = novo;
        } else if(elementoNovo > (int) inicio.getElemento()){
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        } else if(elementoNovo <= (int) fim.getElemento()){
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        } else {
            No aux = inicio;

            while(elementoNovo <= (int) aux.getProximo().getElemento()){
                aux = aux.getProximo();
            }

            novo.setProximo(aux.getProximo());
            novo.setAnterior(aux);
            aux.getProximo().setAnterior(novo);
            aux.setProximo(novo);
        }

        size++;
    };

    public Object dequeue() throws Exception{
        if(isEmpty()){
            return null;
        }

        No aux = inicio;
        inicio = inicio.getProximo();

        if(inicio == null){
            fim = null;
        } else {
            inicio.setAnterior(null);
        }

        size--;
        return aux.getElemento();
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
            if(aux != null){ s.append(" "); }
        }
        return s.toString();
    }
}