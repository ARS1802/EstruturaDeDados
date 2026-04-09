import Pilha.PilhaDinamica;

public class Main {
    public static void main(String[] args) throws Exception {
        //ideia: pilhas de pilhas para trocados em moedas.
        Object[] arr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2};
        Object[] array = {10,10,10,10,0,10,10,10};
        PilhaDinamica pilha = new PilhaDinamica();
        pilha.push(10);
        pilha.push(9);
        pilha.push(7);
        pilha.push(1);
        System.out.println(pilha);
        System.out.println(pilha.pop());
        pilha.pop();
        System.out.println(pilha);


    }
}