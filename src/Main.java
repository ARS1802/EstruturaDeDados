import Lista.*;
import tools.Printer;
import tools.Printer.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Object[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        Object[] sarr = {"10","9","8","7","6","5","4","3","2","1"};

        ListaEstatica lista = new ListaEstatica(sarr);
        lista.remove("9");

    }
}