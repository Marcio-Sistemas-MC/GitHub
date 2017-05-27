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
public class TempoJogoMinutos {
     public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int A, B, C, D;
        String entrada[] = in.readLine().split(" ");
        A = Integer.parseInt(entrada[0]);
        B = Integer.parseInt(entrada[1]);
        C = Integer.parseInt(entrada[2]);
        D = Integer.parseInt(entrada[3]);

        int t1 = A * 60 + B;
        int t2 = C * 60 + D;

        if (A == C && B == D) {
            System.out.printf("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)\n");
        } else if (A > C) {
            int res = ((24*60)-t1) + t2;
            int h = res/60;
            int min  = res % 60;
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", h, min);
        } else {
            int res = t2 - t1;
            int h = res / 60;
            int min = res % 60;
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", h, min);
        }

    }
}
