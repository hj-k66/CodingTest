package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11057 {
    static final int MOD = 10007;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Long[][] dp  = new Long[N+1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = j+1; k < 10; k++) {
                    dp[i][j] += dp[i-1][k]%MOD;
                }
            }
        }

        //출력
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i]%MOD;
        }
        System.out.println(answer%MOD);
    }
}
