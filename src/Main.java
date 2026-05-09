import Fila.FilaOrdenada;

public class Main {
    public static void main(String[] args) throws Exception {
        FilaOrdenada fila = new FilaOrdenada(1,2,3,4,5);
        System.out.println(fila);
        fila.enqueue(3);
        System.out.println(fila);
        fila.dequeue();
        System.out.println(fila);
        fila.dequeue();
        System.out.println(fila);
   }
}