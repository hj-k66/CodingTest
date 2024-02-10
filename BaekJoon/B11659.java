package CodingTest.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 11659 구간 합 구하기 4
풀이 : arr[i] = arr[1] 부터 arr[i]까지의 누적합 저장
-> 2번째 수 ~ 4번쨰 수의 합 = 1~4번째 수의 합 - 1번째 수까지의 합 =  arr[4] - arr[1]
 */
public class B11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        //구간합
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end] - arr[start - 1]).append('\n');
        }

        System.out.println(sb);


    }
}
