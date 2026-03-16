package Lista;

public interface ListaInterface {
    public void add(Object elemento) throws Exception;
    public void remove(Object elemento) throws Exception;
    public void clear() throws Exception;
    public boolean isEmpty() throws Exception;
    public boolean contains(Object elemento) throws Exception;
    public int size() throws Exception;
}
