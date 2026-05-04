package Fila;

import java.util.*;

public class FilaEstatica implements FilaInterface{
    Object[] elementos;
    int i;
    int inicio, fim;

    public FilaEstatica(){};

    FilaEstatica(Object... objects){
        elementos = new Object[objects.length];
        for (int i = 0; i < objects.length; i++){
            elementos[i] = objects[i];
        }
        inicio = 0;
        fim = elementos.length-1;
    };

    @Override
    public void enqueue(Object elemento) throws Exception {
        if(!isEmpty()){
            aumentarLength();
            elementos[fim++] = elemento;
            return;
        }

        elementos = new Object[1];
        inicio = 0;
        fim = elementos.length-1;
    elementos[inicio] = elemento;
    }

    @Override
    public void enqueue(Object valor, Prioridade prioridade) throws Exception {

    }

    @Override
    public Object dequeue() throws Exception {
        return null;
    }

    public void dequeue(Object elemento) throws Exception {
        if(!isEmpty()){
            diminuirLength();
            i--;
            inicio--;
        }
    }

    @Override
    public void clear() throws Exception {
        i = -1;
        elementos = null;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return elementos == null ||elementos.length <=0;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        return false;
    }

    @Override
    public Object peek() throws Exception {
        return elementos[inicio];
    }

    @Override
    public Object peek(Prioridade prioridade) throws Exception {
        return null;
    }

    @Override
    public int size() throws Exception {
        return elementos.length;
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
        StringBuilder sb = new StringBuilder("[ ");
        for(int i = inicio ; i<fim ; i++){
            sb.append(elementos[i]);
            sb.append(" ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
