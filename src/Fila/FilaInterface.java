package Fila;

public interface FilaInterface {
    public void enqueue(Object elemento) throws Exception;
    public void dequeue(Object elemento) throws Exception;
    public void clear() throws Exception;
    public boolean isEmpty() throws Exception;
    public Object peek() throws Exception;
    public int size() throws Exception;
}
