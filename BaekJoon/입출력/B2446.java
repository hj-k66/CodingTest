package CodingTest.BaekJoon.입출력;

import java.io.*;

public class B2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 2 * n - 1; i++) {
            int idx = i;
            if (idx > n) {
                idx = i - 2 * (i % n);
            }
            for (int j = 1; j < idx; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (n - idx) + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

/*
6 >> 4  = 6-(2*1)
7 >> 3  = 7 - (2*2)
8 >> 2  = 8 - (2*3)
9 >> 1
5
예제 출력 1
*********  1 >> 9  = 2*(5-1) + 1
 *******   2 >> 1 7 = 2*(N-2) +1
  *****    3 >> 2 5  = 2*(5-3) +1
   ***     4 >> 3 3
    *      5 >> 4 1
   ***     6 >> 3 3 >> 4
  *****    7 >> 2 5 >> 3
 *******   8 >> 1 7 >> 2
*********  9 >> 9 >> 1
 */

