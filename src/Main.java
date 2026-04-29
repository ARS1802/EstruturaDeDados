import Fila.FilaPrioridade;
import Fila.Prioridade;
import Pilha.PilhaDinamica;

public class Main {
    public static void main(String[] args) throws Exception {
        FilaPrioridade fila = new FilaPrioridade(1,2,3,4,5);
        fila.enqueue(5, Prioridade.ALTA);
        System.out.println(fila);
        fila.enqueue(3);
        System.out.println(fila);
   }
}