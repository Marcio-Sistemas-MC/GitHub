/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Márcio
 */
public class DentroParaFora {
    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        int casos;
        String entrada;
        casos = Integer.parseInt(in.readLine());
        char aux[];
        while(casos > 0) {
            entrada = in.readLine();
            aux = entrada.toCharArray();
            int meio = entrada.length()/2 - 1;
            int i =0, j = meio, k = meio + 1, l = entrada.length()-1;
            while(i < j) {
                char c = aux[i];
                aux[i] = aux[j];
                aux[j] = c;
                i++;
                j--;
                
                c = aux[k];
                aux[k] = aux[l];
                aux[l] = c;
                k++;
                l--;
            }
            System.out.println(aux);
            casos--;
        }
        

    }
}
