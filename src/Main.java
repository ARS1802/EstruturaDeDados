import Lista.*;
import Lista.Dinamica.*;
import Pilha.PilhaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        //ideia: pilhas de pilhas para trocados em moedas.
        Object[] arr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2};
        Object[] array = {10,10,10,10,0,10,10,10};
        PilhaEstatica pe = new PilhaEstatica(arr);
        System.out.println(pe);
        System.out.println(pe.peek());
        pe.push(1919);
        System.out.println(pe.peek());
        System.out.println(pe);
    }
}