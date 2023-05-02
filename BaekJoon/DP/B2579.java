package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 2579 계단 오르기
내 풀이 : 이전 계단 밟은 횟수를 저장해 3번 연속 계단 밟는 경우 고려하려함 >> 답이 안나옴
>> case 1. 연속된 계단의 경우는(직전값) dp[i-3]에 직전값 더해 구함
>> case 2. dp[i-2]
 */
public class B2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //로직
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        if(n >= 2){
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
        System.out.println(dp[n]);

    }
}
