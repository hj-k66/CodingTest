package CodingTest.BaekJoon.이분탐색_삼분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 1654 랜선 자르기
내풀이 : upper bound로 이분탐색
 */
public class B1654  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }
        max++;

        long min = 0;
        long mid;

        while(min < max){
            mid = (max+min) / 2;
            long count = 0;
            for(int i = 0; i < k; i++){
                count += (arr[i] / mid);
            }

            if(count < n){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
