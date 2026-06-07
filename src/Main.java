import ArvoraBinaria.ArvoreBusca;

public class Main {
    public static void main(String[] args) throws Exception {
        ArvoreBusca av = new ArvoreBusca();
        int[] inputs = new int[]{10,5,2};

        for(int i = 0 ; i<inputs.length ; i++){
            av.add(inputs[i]);
        }

        System.out.println(av);
        System.out.println(av.isBalanceada);
   }
}
