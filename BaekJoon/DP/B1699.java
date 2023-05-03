package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 1699 제곱수의 합
내풀이 : dp[i] = i의 제곱수의 합의 최소 항의 갯수
1 ~ N 까지의 수 중 제곱수인 수 + (n - 제곱수) 의 최소 제곱수 갯수 중 최소인 값
ex) (13 - 1) 의 최소 제곱수의 합, (13 - 4)의 최소 제곱수의 합, (13 - 9)의 최소 제곱수의 합
중 가장 작은 값과 +1(1, 4, 9 등 제곱수의 개수는 1개 이니까)
 */
public class B1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if(dp[i] > dp[i - j*j] + 1){
                    dp[i] = dp[i - j*j] + 1;
                }
            }
        }


        System.out.println(dp[n]);


    }

}
