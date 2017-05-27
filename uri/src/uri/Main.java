/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        String entrada;
        char aux[];
        while(in.ready()) {
            entrada = in.readLine();
            aux = entrada.toCharArray();
            boolean mai = false;
            for (int i = 0; i < entrada.length(); i++) {
                if(aux[i] != ' '){
                    if(mai){
                        aux[i] = Character.toLowerCase(aux[i]);
                        mai = false;
                    } else {
                        aux[i] = Character.toUpperCase(aux[i]);
                        mai = true;
                    }
                } 
            }
            System.out.println(aux);
        }
        

    }

}
