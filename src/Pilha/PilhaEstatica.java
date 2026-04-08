package Pilha;

import java.util.Arrays;

public class PilhaEstatica implements PilhaInterface {
    private Object[] elementos;
    private Object topo;
    private int i;

    public PilhaEstatica(int capacidade){
        elementos = new Object[capacidade];
        i = capacidade-1;
    }

    public PilhaEstatica(Object... objects){
        this(objects.length);
        for (int i = 0; i < objects.length; i++){
            elementos[i] = objects[i];
        }
    }

    @Override
    public void push(Object elemento) throws Exception {
        if(elementos[i] != null){
            aumentarLength();
        }
        elementos[i] = elemento;
        topo = elemento;
    }

    @Override
    public Object pop() throws Exception {
        return elementos[i--];
    }

    @Override
    public Object elementAt(int pseudoIndex) {
        return elementos[pseudoIndex];
    }

    @Override
    public Object peek() throws Exception {
        i = elementos.length-1;
        topo = elementos[i];
        return topo;
    }

    @Override
    public void clear() throws Exception {
        i = -1;
        elementos = null;
        topo = null;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return elementos == null || elementos.length<=0 || topo == null;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        return Arrays.stream(elementos).anyMatch(e -> e.equals(elemento));
    }

    @Override
    public int size() throws Exception {
        return elementos.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Arrays.stream(elementos).forEach(e -> sb.append(e).append(", "));
        sb.append("]");
        return sb.toString();
    }

    private void alterarLength(int comprimento){
        i += comprimento;
        Object[] copiaReescalada  = Arrays.copyOf(this.elementos,this.elementos.length+ comprimento);
        this.elementos = copiaReescalada;
    }

    private void aumentarLength(){
        alterarLength(1);
    }

    private void diminuirLength(){
        alterarLength(-1);
    }
}
