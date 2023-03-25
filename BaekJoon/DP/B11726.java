package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[n]);

    }
}

/*
        가로 : n
        세로 : 2

        1  > 1
        2  >  2  (11, 2)
        3  >  3    (111, 21, 12) 1+2 = 3
        4 >  5   (1111, 22, 121, 211, 112)
        5 >  8   (11111, 221, 122,212, 1112, 1121, 1211, 2111)
        6 > 13
        7 > 21
        8 > 34
        9 > 55
 */
