package Pilha;

public interface PilhaInterface {
    public void push(Object elemento) throws Exception;
    public void pop() throws Exception;
    public Object elementAt(int pseudoIndex);
    public Object peek() throws Exception;
    public void clear() throws Exception;
    public boolean isEmpty() throws Exception;
    public boolean contains(Object elemento) throws Exception;
    public int size() throws Exception;
}
