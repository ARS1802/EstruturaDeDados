package Fila;

import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FilaEstatica implements FilaInterface{
    Object[] elementos;
    int size = 0;
    FilaEstatica(){};
    FilaEstatica(Object... objects){
        for (int i = 0; i < objects.length; i++){
            elementos[i] = objects[i];
        }
        size = elementos.length;
    };

    @Override
    public void enqueue(Object elemento) throws Exception {

    }

    @Override
    public void dequeue(Object elemento) throws Exception {

    }

    @Override
    public void clear() throws Exception {

    }

    @Override
    public boolean isEmpty() throws Exception {
        return false;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        return false;
    }

    @Override
    public int size() throws Exception {
        return 0;
    }
}
