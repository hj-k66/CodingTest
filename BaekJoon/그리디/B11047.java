package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[BOJ] 11047 동전 0
나의 idea : 큰 단위 동전부터 갯수 세기
 */
public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n-1; i >= 0 ; i--) {
            answer += k / coins[i];
            k %= coins[i];
        }

        System.out.println(answer);
    }
}
