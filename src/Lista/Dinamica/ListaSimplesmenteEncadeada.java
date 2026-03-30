package Lista.Dinamica;

import Lista.ListaInterface;

public class ListaSimplesmenteEncadeada implements ListaInterface {
    No head;
    int size;

    public ListaSimplesmenteEncadeada(Object elemento){
        head = new No(elemento);
        size = 1;
    }

    public ListaSimplesmenteEncadeada(){
        clear();
    }

    public ListaSimplesmenteEncadeada(Object... elementos){
        head = new No(elementos[0]);
        size = 1;

        No aux = head;
        for (int i = 1 ; i<elementos.length ; i++) {
            aux.setProximo(new No(elementos[i]));
            size++;
            aux = aux.getProximo();
        }
    }

    @Override
    public void add(Object elemento) throws Exception {
        if(!isEmpty()){
            No aux = getTail();
            aux.setProximo(new No(elemento));
            size++;
            return;
        }
        head = new No(elemento);
        size = 1;

    }

    @Override
    public void remove(Object elemento) throws Exception {
        if(contains(elemento)){
            No aux = head;
            No anterior = aux;
            while(aux.getProximo() !=null){
                if(aux.getElemento().equals(elemento)){
                    break;
                }
                anterior = aux;
                aux = aux.getProximo();
            }

            if(aux.equals(head)){
                head = aux.getProximo();
                return;
            }

            anterior.setProximo(aux.getProximo());
        }
    }

    @Override
    public void clear(){
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return head == null || size<1;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        No aux = head;
        while(aux != null){
            if(aux.getElemento().equals(elemento)){
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    @Override
    public int size() throws Exception {
        return size;
    }

    private No getTail() {
        No aux = head;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        return aux;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No aux = head;
        for(int i = 0 ; i < size-1 ; i++){
            sb.append(aux.getElemento()).append(", ");
            aux = aux.getProximo();
        }
        sb.append(aux.getElemento());
        sb.append("]");
        return sb.toString();
    }
}