package ArvoraBinaria;

import java.util.ArrayList;

public class ArvoreBusca {
    No<Integer> raiz;
    int size = 0;
    public boolean isBalanceada = false;
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
            size++;
        }else{
            add(elemento, raiz);
            isBalanceada();
        }
    }

    public void remove(Integer elemento, No<Integer> raiz, No<Integer> pai){
        if(!isEmpty()){
            ArrayList<No<Integer>> list = new ArrayList<>();
            traceElement(elemento, raiz, pai, list);
            if(list.getLast().getElemento() == elemento){
                No<Integer> child = list.getLast();
                No<Integer> parent = list.get(list.size()-2);

                boolean child_is_parentEsquerda = parent.getEsquerda() == child;
                boolean child_is_parentDireita = parent.getDireita() == child;

                System.out.println("\n//REMOVING//");
                System.out.println("CHILD: "+child.getElemento());
                System.out.println("PARENT: "+parent.getElemento());

                //se tiver nenhum filho
                if(!child.hasChildren()){
                    if(child_is_parentEsquerda){
                        parent.cutEsquerda();
                    }
                    if(child_is_parentDireita){
                        parent.cutDireita();
                    }
                }else{
                    //se tiver apenas o direito
                    if((child.hasDireita() && !child.hasEsquerda())){
                        if(child_is_parentEsquerda){
                            parent.setEsquerda(child.getDireita());
                            return;
                        }
                        if(child_is_parentDireita){
                            parent.setDireita(child.getDireita());
                            return;
                        }

                    }

                    //se tiver apenas o esquerdo
                    if(child.hasEsquerda() && !child.hasDireita()){
                        if(child_is_parentEsquerda){
                            parent.setEsquerda(child.getEsquerda());
                            return;
                        }
                        if(child_is_parentDireita){
                            parent.setDireita(child.getEsquerda());
                            return;
                        }
                    }

                    //tem ambos
                    removeByMinimum(child);
                }

            }else{
                System.out.println("Elemento não encontrado!");
            }
        }
        //se o elemento for a raiz da arvore!
    }

    public void remove(Integer elemento){
        if(elemento == raiz.getElemento()){
            removeByMinimum(raiz);
        }else{
            remove(elemento, raiz, null);
        }
        isBalanceada();
        size--;
    }

    private void removeByMinimum(No<Integer> raiz){
        No<Integer> childDireita = raiz.getDireita();
        No<Integer> childEsquerda = raiz.getEsquerda();

        ArrayList<No<Integer>> substitutoTrace = new ArrayList<>();
        traceMin(childDireita, substitutoTrace);

        No<Integer> substituo = substitutoTrace.getLast();
        raiz.setElemento(substituo.getElemento());

        try{
            No<Integer> substituoParent = substitutoTrace.get(substitutoTrace.size()-2);
            substituoParent.cutEsquerda();
        }catch (Exception e){
            raiz.cutDireita();
        }

    }

    private void traceElement(Integer elemento, No<Integer> raiz, No<Integer> pai, ArrayList<No<Integer>> list){
        if(!isEmpty()){
            if(raiz.getElemento() < elemento) {
                list.add(raiz);
                if(raiz.getDireita()!=null){
                    traceElement(elemento, raiz.getDireita(), raiz, list);
                }
            }
            if(raiz.getElemento() > elemento) {
                list.add(raiz);
                if(raiz.getEsquerda()!=null){
                    traceElement(elemento, raiz.getEsquerda(), raiz, list);
                }
            }
            if(raiz.getElemento() == elemento) {
                list.add(raiz);
            }
        }
    }

    public void traceMin(No<Integer> raiz, ArrayList<No<Integer>> list){
        No<Integer> minNode = min(raiz);
        traceElement(minNode.getElemento(),raiz,null,list);
    }

    public No<Integer> min(No<Integer> raiz){
        if(!raiz.hasChildren()){
            return raiz;
        }
        return min(raiz.getEsquerda());
    }

    public No<Integer> max(No<Integer> raiz){
        if(!raiz.hasChildren()){
            return raiz;
        }
        return max(raiz.getDireita());
    }

    private void isBalanceada(){
        if(raiz.hasChildren()){
            int fatorBalanceamento = altura(raiz.getEsquerda()) - altura(raiz.getDireita());
            isBalanceada = fatorBalanceamento <= 1 && fatorBalanceamento >= -1;
        }
    }

    public boolean contains(Integer elemento){
        ArrayList<No<Integer>> list = new ArrayList<>();
        traceElement(elemento,raiz,null,list);
        return list.getLast().getElemento() == elemento;
    }

    public boolean isEmpty(){
        return size == 0 || raiz==null;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if(isEmpty()){
            return "Arvore vazia";
        }

        int altura = altura(raiz) + 1;
        int larguraCelula = String.valueOf(size).length() + 4;
        int tamanhoLinha = size * larguraCelula;

        for(int camada = 0; camada < altura; camada++){
            if(camada == 0){
                builder.append("raiz: ");
            }else{
                builder.append(camada).append(":    ");
            }

            StringBuilder linha = new StringBuilder();

            for(int i = 0; i < tamanhoLinha; i++){
                linha.append(' ');
            }

            buildCamada(raiz, linha, camada, 0, new int[]{0}, larguraCelula);

            while(linha.length() > 0 && linha.charAt(linha.length() - 1) == ' '){
                linha.deleteCharAt(linha.length() - 1);
            }

            builder.append(linha);
            builder.append('\n');
        }

        return builder.toString();
    }

    public static int altura(No<Integer> raiz) {
        if (raiz == null) {
            return -1;
        }

        int alturaEsquerda = altura(raiz.esquerda);
        int alturaDireita = altura(raiz.direita);

        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    private void buildCamada(No<Integer> no, StringBuilder linha, int camada, int nivel, int[] coluna, int larguraCelula){
        if(no == null){
            return;
        }

        buildCamada(no.getEsquerda(), linha, camada, nivel + 1, coluna, larguraCelula);

        if(nivel == camada){
            String texto = no.getElemento().toString();
            int inicio = coluna[0] * larguraCelula;

            for(int i = 0; i < texto.length() && inicio + i < linha.length(); i++){
                linha.setCharAt(inicio + i, texto.charAt(i));
            }
        }

        coluna[0]++;

        buildCamada(no.getDireita(), linha, camada, nivel + 1, coluna, larguraCelula);
    }

}
