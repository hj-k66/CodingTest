package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2491. 수열
dp[n][0] : n번째 수열까지 중, 가장 긴 연속하는 증가하는 수열의 길이
dp[n][1] : n번째 수열까지 중, 가장 긴 연속하는 감소하는 수열의 길이
 */
public class B2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i]){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = 1;
             }
            else if(arr[i-1] > arr[i]){
                dp[i][0] = 1;
                dp[i][1] = dp[i-1][1] + 1;
            }else{
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(max);

    }
}
