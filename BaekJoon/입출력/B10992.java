package CodingTest.BaekJoon.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < (i - 1) * 2 - 1; j++) {
                System.out.print(" ");
            }
            if (i != 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print("*");
        }
    }
}
/*
예제 입력 1
1
예제 출력 1
*
예제 입력 2
2
예제 출력 2
 *  1 1
*** 0 3
예제 입력 3
3
예제 출력 3
  *  2 1
 * * 1 1 " " 1
***** 0 5
예제 입력 4
4
예제 출력 4
   *    3 1
  * *   2 1 " "*1 1
 *   *  1 1 " "*3 1
******* 0 7
 5
    *
   * *   2 : 111 (i-1)*2-1 == 2i-3
  *   *  3 : 131
 *     * 4 : 151
         5 : 171
*********
 */
