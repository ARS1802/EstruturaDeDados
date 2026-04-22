import Fila.FilaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        FilaEstatica fe = new FilaEstatica();
        fe.enqueue(1);
        fe.enqueue(2);
        fe.enqueue(3);
        System.out.println(fe);
    }
}