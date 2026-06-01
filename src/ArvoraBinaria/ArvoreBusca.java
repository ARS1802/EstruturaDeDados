package ArvoraBinaria;

public class ArvoreBusca {
    No<Integer> raiz;
    int size = 0;
    //Se for maior, vai pra direita
    //Se for menor, vai pra esquerda

    public ArvoreBusca(Integer elemento){
        add(elemento);
    }

    public ArvoreBusca(){}

    public void add(Integer elemento, No<Integer> raiz){
        if(raiz == null){
            raiz = new No<Integer>(elemento);
            size++;
        } else{
            if(raiz.getElemento() < elemento) {
                if(raiz.getDireita()==null){
                    raiz.setDireita(elemento);
                    size++;
                    return;
                }
                add(elemento, raiz.getDireita());
            }
            if(raiz.getElemento() >= elemento) {
                if(raiz.getEsquerda()==null){
                    raiz.setEsquerda(elemento);
                    size++;
                    return;
                }
                add(elemento, raiz.getEsquerda());
            }
        }
    }

    public void add(Integer elemento){
        if(raiz == null){
            raiz = new No<Integer>(elemento);
        }else{
            add(elemento, raiz);
        }
    }

    public void remove(Integer elemento, No<Integer> raiz, No<Integer> pai){
        if(!isEmpty()){
            if(raiz.getElemento() < elemento) {
                //vai pra direita
            }
            if(raiz.getElemento() > elemento) {
                //vai pra esquerda
            }
            if(raiz.getElemento() == elemento) {
                //se raiz tiver filhos...
                //se raiz river apenas um filho...
                //se raiz não tiver nenhum filho
            }
        }
    }

    public void remove(Integer  elemento){
        if(isEmpty()){
            remove(elemento, raiz, raiz);
        }
    }

    public boolean isEmpty(){
        return size == 0 || raiz==null;
    }
}
