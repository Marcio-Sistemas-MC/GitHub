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

    public static long fatorial(long num) {
        if(num == 0) {
            return 1;
        } else {
            
            long fat = num;
            while(--num > 0) {
                fat *= num;
            }
            return fat;
        }
    }
    
    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        int a,b;
        String entrada[];
        while(in.ready()) {
            entrada = in.readLine().split(" ");
            a = Integer.parseInt(entrada[0]);
            b = Integer.parseInt(entrada[1]);
            System.out.println(fatorial(a) + fatorial(b));
        } 
    }

}
