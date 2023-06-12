package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 11052 카드 구매하기
내풀이 : dp[n]: 합쳐서 n의 카드 가격의 최댓값
 */
public class B11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= i/2; j++){
                dp[i] = Math.max(dp[i], arr[j] + dp[i-j]);
            }
            dp[i] = Math.max(dp[i], arr[i]);
        }
        System.out.println(dp[n]);
    }
}

/*
합쳐서 4의 최댓값
    1, 합쳐서 3의 최댓값 >> 111(3), 12(6), 3(6)
    2, 합쳐서 2
            1합쳐서 1
            2
    4
-------------------
합쳐서 10의 최댓값
    1, 합쳐서 9 >>
    2, 합쳐서 8
    3, 합쳐서 7
    4, 합쳐서 6
    5, 합쳐서 5 >> max(1합쳐서 4, 2합쳐서 3)
 */