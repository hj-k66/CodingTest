package CodingTest.BaekJoon.이분탐색_삼분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[BOJ] 2805 나무 자르기
내풀이 : upper bound로 이분탐색
 */

public class B2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
        }
        max++;
        long min = 0;
        while(min < max){
            long mid = (max + min) / 2;
            long height = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] <= mid){
                    continue;
                }
                height += (arr[i] - mid);
            }
            if(height < m){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
