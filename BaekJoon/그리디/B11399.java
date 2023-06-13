package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[BOJ] 11399 ATM
내풀이 : 가장 시간이 작은거부터 누적합
 */

public class B11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = arr[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                sum += arr[j];
            }
        }
        System.out.println(sum);
    }
}
