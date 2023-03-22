package CodingTest.BaekJoon.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2*n-1; i++) {
            int idx = i;
            if(i > n){
                idx = i - 2*(i%n);
            }
            for (int j = 0; j < idx; j++) {
                System.out.print("*");
            }
            for (int k = 0; k < 2 * (n - idx); k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < idx; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
/*
5
예제 출력  2×N-1번째 줄까지
*        * 1 8 1  - 1
**      ** 2 6 2  - 2
***    *** 3 4 3
****  **** 4 2 4
********** 5 0 5 - 5
****  **** 4 2 4 - 6 >> 4
***    *** 3 4 3 - 7 >> 3
**      ** 2 6 2 - 8 >> 2
*        * 1 8 1 - 9 >> 1
 */
// i = 6 - 2     i = i - 2*(n%i);