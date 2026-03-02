import Lista.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] nomes = new String[]{"Arhur","Maria","Samylla","Samuel"};
        ListaEstatica lista = new ListaEstatica(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        lista.add(11);
        lista.add(22);
        lista.remove(13);
        lista.imprimir();
        System.out.printf("\n\n\tlength: %d", lista.length());

    }
}