package Lista;
/*  CONSIDERAÇÕES:
- Não usarei a classe List do Java.
- Java não suporta um array de Generics (T).
* */


import java.util.Arrays;

public class Lista {
    protected int i;
    protected Object[] elemento;


    protected Lista(int capacidade){
        i = capacidade-1;
        elemento = new Object[capacidade];
    }

    protected Lista(){
        //posso chamar construtores dentro de construtores!
        this(10);
    }

    protected Lista(Object[] arr){
        //posso chamar construtores dentro de construtores!
        this(arr.length);

        //copia cada elemento de arr para elemento[]
        for(int j=0;j<arr.length;j++){
            elemento[j] = arr[j];
        }
    }

        //ou "size()"
    public int length() {
        return elemento.length;
    }

    public void clear(){
        i = -1;
        elemento = null;
    }

    public boolean isEmpty() throws Exception{
        if(elemento.length<=0){
            throw new Exception("Lista vazia!");
        } else{
            return false;
        }
    }


    public void imprimir()  throws Exception{
        if(!isEmpty()){
            for(Object elemento : this.elemento){
                System.out.println(elemento);
            }
        }
    }


//-------------------- métodos personalizados ----------------

//    public boolean isHomogena(){
//        boolean homo = false;
//        Class<?> classe = elemento[0].getClass();
//        for(int j = 0; j<this.i; j++){
//            if(!classe.equals(this.elemento[j].getClass())){
//                return false;
//            }
//        }
//        return true;
//    }

}

