package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 2156 포도주 시식
나의 풀이 : OOX, XOO, OxO 경우
>> dp 점화식 : max( dp[i-1], dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i]
Hint
- dp[3]까지 따로 고려하기
 */
public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        if (n == 1){
            System.out.println(wine[1]);
            return;
        }
        if(n==2){
            System.out.println(wine[1] + wine[2]);
            return;
        }
        dp[1] = wine[1];
        dp[2] = wine[1]+wine[2];

        for(int i = 3; i <= n; i++){
            if(i == 3){
                dp[i] = Math.max(dp[i-1], Math.max(wine[i-2] + wine[i], wine[i-1] + wine[i]));
            }
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-3]+wine[i-1] + wine[i]), dp[i-2] +wine[i]);
        }

        System.out.println(dp[n]);

    }
}
