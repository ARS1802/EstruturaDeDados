import ArvoraBinaria.ArvoreBusca;
import ArvoraBinaria.No;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArvoreBusca av = new ArvoreBusca();
        int[] inputs = new int[]{7,5,12,2,6,9,21,19,25,3,4,23};
        for(int i = 0 ; i<inputs.length ; i++){
            av.add(inputs[i]);
        }

        av.remove(21);
        System.out.println();
   }
}