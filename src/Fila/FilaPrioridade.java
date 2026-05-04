package Fila;
//FIFO
public class FilaPrioridade  implements FilaInterface{
    private No primeiro;
    private No ultimo;
    private int size = 0;

    public FilaPrioridade() {}

    public FilaPrioridade(Object elemento) throws Exception {
        enqueue(elemento);
    }

    public FilaPrioridade(Object... elementos){
        primeiro = new No(elementos[0]);
        size = elementos.length;

        No aux = primeiro;
        for(int i=1;i<elementos.length;i++){
            No novo = new No(elementos[i]);
            aux.setProximo(novo);
            novo.setAnterior(aux);
            aux = novo;
        }
        ultimo = aux;
    }


    @Override
    public void enqueue(Object elemento) throws Exception {
        enqueue(elemento,Prioridade.BAIXA);
    }

    @Override
    public void enqueue(Object elemento, Prioridade prioridade) throws Exception {
        if(isEmpty()){
            primeiro = new No(elemento, prioridade);
            ultimo = primeiro;
            size++;
        } else{
            No aux = new No(elemento, prioridade);
            ultimo.setProximo(aux);
            aux.setAnterior(ultimo);
            ultimo = aux;
            size++;
        }
    }

    @Override
    public Object dequeue() throws Exception {
        No aux = primeiro;
        Dado d = aux.getDado();

        for(int i = 0 ; i<=2 ; i++){
            int prioridade = d.getPrioridade().getValor();
            while(prioridade != i && aux.getProximo()!=null){
                aux = aux.getProximo();
                d = aux.getDado();
                prioridade = d.getPrioridade().getValor();
            }
            if(prioridade == i){
                //encontrou?
                if(aux.getAnterior()==null){
                    primeiro = aux.getProximo();
                    size--;
                    break;
                }
                if(aux.getProximo()==null){
                    ultimo = aux.getAnterior();
                    size--;
                    break;
                }
                No anterior = aux.getAnterior();
                No proximo = aux.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                size--;
                break;
            }
            aux = primeiro;
            d = aux.getDado();
        }
        return d.getElemento();

    }

    @Override
    public Object peek() throws Exception {
        return primeiro.getElemento();
    }

    @Override
    public Object peek(Prioridade prioridade) throws Exception {
        No aux = primeiro;
        Dado d = aux.getDado();
        while(d.getPrioridade() != prioridade && aux.getProximo()!=null){
            aux = aux.getProximo();
            d = aux.getDado();
        }

        return (d.getPrioridade() == prioridade) ? d.getElemento() : null;
    }

    @Override
    public void clear() throws Exception {
        primeiro = null;
        ultimo = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return primeiro == null && size == 0;
    }

    @Override
    public boolean contains(Object elemento) throws Exception {
        No aux = primeiro;
        while(aux != null){
            if(aux.getElemento().equals(elemento)){
                return true;
            } else{
                aux = aux.getProximo();
            }
        };
        return false;
    }

    @Override
    public int size() throws Exception {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        No aux = primeiro;
        while(aux != null){
            s.append(aux.getElemento());
            s.append(" ");
            aux = aux.getProximo();
        }
        s.append("\n");
        return s.toString();
    }
}
