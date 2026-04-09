package Pilha;

public class PilhaDinamica implements PilhaInterface{
    No topo;
    int size = 0;

    public PilhaDinamica(){}

    public PilhaDinamica(Object... elementos) throws Exception {
        for(int i = 0; i < elementos.length; i++){
            push(elementos[i]);
        }
        size = elementos.length;
    }

    @Override
    public void push(Object elemento) throws Exception {
        No novo = new No(elemento);
        novo.setAnterior(topo);
        topo = novo;
        size++;
    }

    @Override
    public Object pop() throws Exception {
        No aux = topo;
        topo = topo.getAnterior();
        size--;
        return aux.getElemento();
    }

    @Override
    public Object elementAt(int pseudoIndex) {
        int buffer = pseudoIndex;
        if(buffer<0){
            return null;
        }

        No aux = topo;
        while(aux!=null && buffer>=0){
            aux = aux.getAnterior();
            buffer--;
        }
        return aux;
    }

    @Override
    public Object peek() throws Exception {
        return topo;
    }

    @Override
    public void clear() throws Exception {
        topo = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return topo == null && size == 0;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        No aux = topo;
        while(aux!=null){
            if(aux.getElemento().equals(elemento)){
                return true;
            }
            aux = aux.getAnterior();
        }
        return false;
    }

    @Override
    public int size() throws Exception {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        No aux = topo;
        while(aux != null){
            sb.append(aux.getElemento()).append(", ");
            aux = aux.getAnterior();
        }
        int sl = sb.length();
        sb.delete(sl-2, sl);
        sb.append(" ]");
        return sb.toString();
    }
}
