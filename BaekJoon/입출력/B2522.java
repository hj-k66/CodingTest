package CodingTest.BaekJoon.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 2*n; i++) {
            int idx = i;
            if(idx > n){
                idx = n - i%n;
            }
            for (int j = 0; j < n-idx; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < idx; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
