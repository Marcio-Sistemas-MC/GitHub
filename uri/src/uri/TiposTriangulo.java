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
 * para submeter no URI o nome da casse deve ser Main;
 */
public class TiposTriangulo {
     public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        double A, B, C;
        String entrada[] = in.readLine().split(" ");
        A = Double.parseDouble(entrada[0]);
        B = Double.parseDouble(entrada[1]);
        C = Double.parseDouble(entrada[2]);

        double maior, ordem[] = new double[3];
        ordem[0] = A;
        ordem[1] = B;
        ordem[2] = C;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (ordem[j] < ordem[j + 1]) {
                    maior = ordem[j + 1];
                    ordem[j + 1] = ordem[j];
                    ordem[j] = maior;
                }
            }
        }
        A = ordem[0];
        B = ordem[1];
        C = ordem[2];
        double d = A * A;
        double e = (B * B) + (C * C);
        if (A >= B + C) {
            System.out.printf("NAO FORMA TRIANGULO\n");
        } else {
            if (d == e) {
                System.out.printf("TRIANGULO RETANGULO\n");
            }
            if (d > e) {
                System.out.printf("TRIANGULO OBTUSANGULO\n");
            }
            if (d < e) {
                System.out.printf("TRIANGULO ACUTANGULO\n");
            }
            if (A == B && B == C) {
                System.out.printf("TRIANGULO EQUILATERO\n");
            }
            if ((A == B && B != C) || (A == C && C != B) || (B == C && C != A)) {
                System.out.printf("TRIANGULO ISOSCELES\n");
            }
        }
    }
}
