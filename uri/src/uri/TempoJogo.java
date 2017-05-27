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
public class TempoJogo {
     public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int A, B;
        String entrada[] = in.readLine().split(" ");
        A = Integer.parseInt(entrada[0]);
        B = Integer.parseInt(entrada[1]);

        if(A==B) {
            System.out.printf("O JOGO DUROU 24 HORA(S)\n");
        }else if (A < B) {
            System.out.printf("O JOGO DUROU %d HORA(S)\n", (B-A));
        } else{
            int C = (24 - A) +B;
            System.out.printf("O JOGO DUROU %d HORA(S)\n",C);
        }
        
    }
}
