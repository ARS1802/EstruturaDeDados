import Lista.*;
import Lista.Dinamica.ListaDuplamenteEncadeada;
import Lista.Dinamica.ListaSimplesmenteEncadeada;
import tools.Printer;
import tools.Printer.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Object[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        Object[] array = {10,10,10,10,0,10,10,10};

        ListaSimplesmenteEncadeada LSE = new ListaSimplesmenteEncadeada(arr);


        System.out.println(LSE);
    }
}