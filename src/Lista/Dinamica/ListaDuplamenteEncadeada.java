package Lista.Dinamica;
import Lista.ListaInterface;

public class ListaDuplamenteEncadeada implements ListaInterface {
    No inicio;
    No fim;
    int size =0;

    @Override
    public void add(Object elemento) throws Exception {
        if(isEmpty()){
            inicio = new No(elemento);
            size++;
        } else{
            No aux = new No(elemento);
            fim.setProximo(aux);
            fim = aux;
            size++;
        }
    }

    @Override
    public void remove(Object elemento) throws Exception {
        No aux = inicio;
        while(aux.getProximo().getProximo() != null){
            aux = aux.getProximo();
            if(aux.getProximo().equals(elemento)){

            }
        }
    }

    @Override
    public void clear() throws Exception {

    }

    @Override
    public boolean isEmpty() throws Exception {
        return inicio == null;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        return false;
    }

    @Override
    public int size() throws Exception {
        return 0;
    }

    public ListaDuplamenteEncadeada(Object valor){

    }
}
