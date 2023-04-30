package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 11054 가장 긴 바이토닉 부분 수열
내 풀이 : 기준점인 Sk를 완전탐색하면서 증가하는 부분 수열, 감소하는 부분 수열 나눠서 구함
 */
public class B11054 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        int answer = 1;
        for (int i = 0; i < n; i++) { //sk
            int smallAnswer = 1;
            int largeAnswer = 1;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int j = 1; j < i+1; j++) { // 증가하는 부분 수열
                dp[j] = 1;
                 for (int k = 0; k < j; k++) {
                         if(arr[j] > arr[k] && dp[k] >= dp[j]){
                             dp[j] = dp[k]+1;
                     }
                }
                smallAnswer = Math.max(smallAnswer, dp[j]);
            }
            dp[i] = 1;
            for (int j = i+1; j < n; j++) { // 감소하는 부분 수열
                dp[j] = 1;
                for (int k = i; k < j; k++) {
                        if(arr[j] < arr[k] && dp[k] >= dp[j]){
                            dp[j] = dp[k]+1;

                    }

                }
                largeAnswer = Math.max(largeAnswer, dp[j]);
            }
            if(answer < smallAnswer + largeAnswer){
                answer  = smallAnswer + largeAnswer;
            }
        }
        System.out.println(answer-1);
    }
}
