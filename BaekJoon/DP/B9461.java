package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
[BOJ] 9461 파도반 수열
내풀이 : dp[n] = dp[n-1] + dp[n-5]
>> dp[n] = dp[n-2] + dp[n-3]으로도 가능
 */
public class B9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n+1];
            if(n == 1 || n == 2 || n == 3){
                System.out.println(1);
                continue;
            }
            if(n == 4 || n == 5){
                System.out.println(2);
                continue;
            }
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;
            for(int i = 6; i < n+1; i++){
                dp[i] = dp[i-1] + dp[i-5];
            }

            System.out.println(dp[n]);
        }
    }
}
