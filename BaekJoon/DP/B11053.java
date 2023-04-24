package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 가장 긴 증가하는 부분 수열
나의 idea : dp[i] = i까지의 최대 수열의 길이
>> 이전 최대 길이의 마지막 값을 어떻게 가져올지 못 구함
>> LIS ( Longest increasing Subsequence) 문제
>> 앞에서부터 i까지 다시 탐색하여 arr[i]가 크고, dp[i]가 작을 때, 최대 길이를 업데이트
 */
public class B11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        int answer = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
