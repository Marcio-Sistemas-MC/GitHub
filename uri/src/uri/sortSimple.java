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
public class sortSimple {
    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int A, B, C;
        String entrada[] = in.readLine().split(" ");
        A = Integer.parseInt(entrada[0]);
        B = Integer.parseInt(entrada[1]);
        C = Integer.parseInt(entrada[2]);

        int maior, ordem[] = new int[3];
        ordem[0] = A;
        ordem[1] = B;
        ordem[2] = C;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (ordem[j] > ordem[j + 1]) {
                    maior = ordem[j + 1];
                    ordem[j + 1] = ordem[j];
                    ordem[j] = maior;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d\n",ordem[i]);
        }
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s\n",entrada[i]);
        }
       // System.out.println("");
    }
}
