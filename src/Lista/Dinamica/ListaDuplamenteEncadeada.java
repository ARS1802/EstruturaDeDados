package Lista.Dinamica;
import Lista.ListaInterface;

public class ListaDuplamenteEncadeada implements ListaInterface {
    No inicio;
    No fim;
    int size =0;
    int incrivelvarival = 0;

    public ListaDuplamenteEncadeada(Object valor) throws Exception {
        inicio = new No(valor);
        size++;
        incrivelvarival++;
    }
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
        incrivelvarival++;
    }

    @Override
    public void remove(Object elemento) throws Exception {
        No aux = fim;
        No anterior, proximo;
        while(aux.getAnterior() != null){
            anterior = aux.getAnterior();
            proximo = aux.getProximo();
            if(aux.getValor().equals(elemento)){
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                aux.setAnterior(null);
                aux.setProximo(null);
                size--;
            }
            aux = aux.getAnterior();
        }
    }

    @Override
    public void clear() throws Exception {
        inicio = null;
        fim = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return inicio == null && size == 0;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        No aux = inicio;
        while(aux.getProximo() != null){
            if(aux.getValor().equals(elemento)){
                return true;
            } else{
                aux = aux.getProximo();
            }
        };
        return false;
    }

    @Override
    public int size() throws Exception {
        return size;
    }

}
