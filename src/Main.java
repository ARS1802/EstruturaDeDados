import Lista.*;
import Lista.Dinamica.ListaDuplamenteEncadeada;
import tools.Printer;
import tools.Printer.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Object[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        Object[] array = {10,10,10,10,0,10,10,10};

        ListaDuplamenteEncadeada lde = new ListaDuplamenteEncadeada(arr);
        lde.add(10);
        lde.add(10);
        while(lde.contains(10)){
            lde.remove(10);
        }

//        ListaDuplamenteEncadeada teste =  new ListaDuplamenteEncadeada(new Object[] {10,10});
//        teste.add(10);

        System.out.println(lde);
    }
}