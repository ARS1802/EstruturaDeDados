package Lista;

import java.util.Arrays;

public class ListaEstatica extends Lista {
    public ListaEstatica(){
        super();
    }
    public ListaEstatica(int capacidade){
        super(capacidade);
    }
    public ListaEstatica(Object[] arr){
        super(arr);
    }
    private boolean isValidIndex(int index) throws Exception{
        if(index<0 || index>i){
            throw new Exception(String.format("Indíce %d inválido!",index));
        } else {
            return true;
        }
    }

    public Object get(int index) throws Exception{
        if(isValidIndex(index)){
            return elemento[index];
        } else{
            return null;
        }
    }

    public boolean contains(Object element) throws Exception{
        if(!isEmpty()){
            for (int j = 0; j < elemento.length; j++) {
                if(element.equals(elemento[j])){
                    return true;
                }
            }
        }
        return false;
    }

    //sobrescreve elemento[] com uma cópia do antigo aonde o último elemento é o fornecido
    public void add(Object elemento) throws Exception {
        aumentarLength();
        this.elemento[i] = elemento;
    }

    public void add(Object elemento, int posicao) throws Exception{
        if(isValidIndex(posicao)){
            this.elemento[posicao] = elemento;
            this.i++;
        }
    }

    public void add(Object[] arr) throws Exception {
        for(Object elemento : arr){
            add(elemento);
        }
    }

    //guarda apenas a referencia do array por enquanto
    public void add(Object[] arr, boolean asObject) throws Exception {
        if(asObject){
            aumentarLength();
            this.elemento[i] = arr;
        }
    }

    public void remove(int posicao) throws Exception {
        if(isValidIndex(posicao)){
            shift(posicao,1);
        }
    }

    public void remove(Object elemento) throws Exception {
        if(!isEmpty() && contains(elemento)){
            for (int j = 0; j < this.elemento.length; j++) {
                if(elemento.equals(this.elemento[j])){
                    remove(j);
                }
            }
        }
    }

    public int indexOf(Object elemento){
        for(int i = 0; i<this.i ; i++){
            if(this.elemento[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    protected void aumentarLength(){
        alterarLength(1);
    }

    protected void diminuirLength(){
        alterarLength(-1);
    }

    protected void alterarLength(int comprimento){
        i += comprimento;
        Object[] copiaReescalada  = Arrays.copyOf(this.elemento,this.elemento.length+ comprimento);
        this.elemento = copiaReescalada;
    }



//-------------------- métodos personalizados ----------------

    public void shift(int fromIndex, int amount){
        Object[] bufferArr = Arrays.copyOfRange(elemento, fromIndex+amount, elemento.length);
        int j = 0;
        for(int i = fromIndex; i<elemento.length && j<bufferArr.length; i++){
            this.elemento[i] = bufferArr[j++];
        }
        if(amount > 0){
            diminuirLength();
        }
        if(amount < 0){
            aumentarLength();
        }
    }
}
