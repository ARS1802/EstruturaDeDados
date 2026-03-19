package Lista.Dinamica;
import Lista.ListaInterface;


public class ListaDuplamenteEncadeada implements ListaInterface {
    No inicio;
    No fim;
    int size =0;

    public ListaDuplamenteEncadeada(Object valor) throws Exception {
        inicio = new No(valor);
        size++;
    }

    public ListaDuplamenteEncadeada(Object... valores){
        inicio = new No(valores[0]);
        size = valores.length;

        No aux = inicio;
        for(int i=1;i<valores.length;i++){
            No novo = new No(valores[i]);
            aux.setProximo(novo);
            novo.setAnterior(aux);
            aux = novo;
        }
        fim = aux;
    }
    @Override
    public void add(Object elemento) throws Exception {
        if(isEmpty()){
            inicio = new No(elemento);
            size++;
        } else{
            No aux = new No(elemento);
            fim.setProximo(aux);
            aux.setAnterior(fim);
            fim = aux;
            size++;
        }
    }

    @Override
    public void remove(Object elemento) throws Exception {
        if(contains(elemento)){
            No atual = inicio;
            while(atual != null){
                No anterior = atual.getAnterior();
                No proximo = atual.getProximo();

                if(atual.getElemento().equals(elemento)){
                    if(atual.equals(inicio)){
                        proximo.setAnterior(null);
                        inicio = proximo;
                    } else if(atual.equals(fim)){
                        anterior.setProximo(null);
                        fim = anterior;

                    } else{
                        proximo.setAnterior(anterior);
                        anterior.setProximo(proximo);
                    }
                    break;
                }

                atual = proximo;
            }
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
        while(aux != null){
            if(aux.getElemento().equals(elemento)){
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

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        No aux = inicio;
        while(aux != null){
            s.append(aux.getElemento());
            s.append(" ");
            aux = aux.getProximo();
        }
        s.append("\n");
        return s.toString();
    }
}
