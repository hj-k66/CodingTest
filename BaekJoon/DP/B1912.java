package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 1912 연속합
내 풀이 : dp[i] : i까지의 최대 연속합
- case 1. 현재 자기 자신만(arr[i])
- case 2. 이전 최댓값 + 현재 자신의 값 (dp[i-1] + arr[i])
>> 값 비교이므로 if 대신 Math.max 이용하기
 */
public class B1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        int[] dp = new int[n];
        dp[0] = arr[0];
        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
