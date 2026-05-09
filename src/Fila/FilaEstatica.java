package Fila;

import java.util.*;

public class FilaEstatica{
    Object[] elementos;
    int i;
    int inicio, fim;

    public FilaEstatica(int n){
        elementos = new Object[n];
        inicio = fim = 0;
    };

    public FilaEstatica(Object... objects){
        elementos = new Object[objects.length];
        for (int i = 0; i < objects.length; i++){
            elementos[i] = objects[i];
        }
        inicio = 0;
        fim = elementos.length-1;
    };

    public void enqueue(Object elemento) throws Exception {
        if (!isEmpty()) {
            aumentarLength();
            elementos[++fim] = elemento;
            return;
        }

        elementos = new Object[1];
        inicio = 0;
        fim = elementos.length - 1;
        elementos[inicio] = elemento;
    }


    public Object dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Fila vazia!!");
        return elementos[inicio++];
    }

    public void clear() throws Exception {
        i = -1;
        elementos = null;
        inicio = 0;
        fim = -1;
    }

    public boolean isEmpty(){
        return elementos == null || inicio > fim;
    }

    public Object peek() throws Exception {
        if(isEmpty())
            throw new Exception("Fila vazia!!");
        return elementos[inicio];
    }

    public int size() throws Exception {
        return isEmpty() ? 0:(fim - inicio)+1;
    }

    private boolean isValidIndex(int index) throws Exception{
        if(index<0 || index>i){
            throw new Exception(String.format("Indíce %d inválido!",index));
        } else {
            return true;
        }
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
    @Override
    public String toString(){
        try {
            if(isEmpty()){
                return "";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        StringBuilder sb = new StringBuilder(" ");
        for(int i = inicio ; i<=fim ; i++){
            sb.append(elementos[i]);
            sb.append(", ");
        }

        return sb.toString().substring(0,sb.length()-2);
    }
}
