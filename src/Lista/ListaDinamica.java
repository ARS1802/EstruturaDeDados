package Lista;

public class ListaDinamica {
    No inicio;
    int length = 0;

    public ListaDinamica(int... valor){
        inicio = new No(valor[0]);
        length++;
        No buffer = inicio;
        for (int i = 1; i < valor.length; i++) {
            buffer.prox = new No(valor[i]);
            buffer = buffer.prox;
            length++;
        }
    }

    void add(int valor){
        if(isEmpty()){
            inicio = new No(valor);
            length++;
        }else {
            No buffer = inicio;
            while (buffer.prox != null) {
                buffer = buffer.prox;
            }
            buffer.prox = new No(valor);
        }
    }

    void remove(int valor){
        if(!isEmpty()){
            No buffer = inicio;
            while (buffer.prox.prox.valor != valor) {
                buffer = buffer.prox;
            }
            length--;
            buffer.prox = null;
        }
    }

    void removeUltimo(){
        if(!isEmpty()){
            No buffer = inicio;
            while (buffer.prox.prox != null) {
                buffer = buffer.prox;
            }
            length--;
            buffer.prox = null;
        }
    }

    void clear(){
        if(!isEmpty()) {
            System.out.println("A lista está vazia!");
        }
        if (inicio.prox == null){
            inicio = null;
            length = 0;
        }
    }

    boolean contains(int valor){
        if(!isEmpty()){
            No buffer = inicio;
            while (buffer.valor != valor) {
                if (buffer.prox == null) {
                    break;
                }
                buffer = buffer.prox;
            }
            return buffer.valor == valor;
        }else{
            return false;
        }
    }

    boolean isEmpty(){
        return (inicio==null) && (length<=0);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No buffer = inicio;
        while (buffer.prox != null){
            sb.append(String.format("%d ,",buffer.valor));
        }
        sb.append("]");
        return sb.toString();
    }
}
