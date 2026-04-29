package Fila;

public interface FilaInterface {
    public void enqueue(Object valor) throws Exception;
    public void enqueue(Object valor, Prioridade prioridade) throws Exception;
    public Object dequeue() throws Exception;
    public Object peek() throws Exception;
    public Object peek(Prioridade prioridade) throws Exception;
    public void clear()throws Exception;
    public boolean isEmpty() throws Exception;
    public boolean contains(Object elemento) throws Exception;
    public int size() throws Exception;
}
