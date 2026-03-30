package Lista;

import java.util.Arrays;

public class ListaEstatica implements ListaInterface {
    private Object[] elementos;
    private int i;

    public ListaEstatica(int capacidade){
        elementos = new Object[capacidade];
        i = capacidade-1;
    }

    public ListaEstatica(){}

    public ListaEstatica(Object... objects){
        this(objects.length);
        for (int i = 0; i < objects.length; i++){
            elementos[i] = objects[i];
        }
    }

    @Override
    public void clear() {
        i = -1;
        elementos = null;
    }

    @Override
    public boolean isEmpty() throws Exception{
        return elementos == null ||elementos.length<=0;
    }

    private boolean isValidIndex(int index) throws Exception{
        if(index<0 || index>i){
            throw new Exception(String.format("Indíce %d inválido!",index));
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return elementos.length ;
    }

    @Override
    public void add(Object elemento) throws Exception {
        if(!isEmpty()){
            aumentarLength();
            elementos[i] = elemento;
            return;
        }

        elementos = new Object[1];
        i = 0;
        elementos[i] = elemento;
    }

    @Override
    public void remove(Object elemento) throws Exception {
        if(!isEmpty() && contains(elemento)){
            for (int j = 0; j < this.elementos.length; j++) {
                if(elemento.equals(this.elementos[j])){
                    remove(j);
                }
            }
        }

    }

    public void remove(int index) throws Exception{
        alterarLength(index*(-1));
    }

    public int indexOf(Object elemento){
        for(int i = 0; i<this.i ; i++){
            if(this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
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

    public Object get(int index) throws Exception{
        if(isValidIndex(index)){
            return elementos[index];
        } else{
            return  null;
        }
    }


    @Override
    public boolean contains(Object elemento) {
        return false;
    }


    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("[");
        for (Object elemento : elementos){
            s.append(elemento);
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}
