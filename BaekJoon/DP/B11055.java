package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j]+arr[i], dp[i]);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
