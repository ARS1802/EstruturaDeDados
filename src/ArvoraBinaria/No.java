package ArvoraBinaria;

// <T> declara um "tipo generico": a classe nao fica presa a Object, Integer, String etc.
// Quem usar No<T> escolhe o tipo. Exemplo: No<Integer>, No<String>, No<Pessoa>.
public class No<T> {
    // T significa "o mesmo tipo escolhido na criacao do No".
    // Se for No<Integer>, elemento sera Integer. Se for No<String>, elemento sera String.
    private T elemento;

    // Como direita e esquerda sao filhos da arvore, eles tambem devem ser No<T>.
    // Isso garante que todos os nos da mesma arvore guardem o mesmo tipo de valor.
    private No<T> direita;
    private No<T> esquerda;

    public boolean hasChildren(){
        return !(direita == null && esquerda == null);
    }

    // O construtor recebe T, entao o compilador impede valores de outro tipo.
    public No(T elemento){
        this.elemento = elemento;
    }

    // O getter retorna T. Assim, quem chamar getElemento() nao precisa fazer casting.
    public T getElemento(){
        return elemento;
    }

    // O setter tambem recebe T, mantendo a seguranca de tipo.
    public void setElemento(T elemento){
        this.elemento = elemento;
    }

    public No<T> getDireita(){
        return direita;
    }

    // Este metodo so aceita outro No<T>, evitando misturar tipos na mesma arvore.
    public void setDireita(No<T> direita){
        this.direita = direita;
    }

    public void setDireita(T elemento){
        this.direita = new No<T>(elemento);
    }

    public No<T> getEsquerda(){
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda){
        this.esquerda = esquerda;
    }

    public void setEsquerda(T elemento){
        this.esquerda = new No<T>(elemento);
    }
}
