package CodingTest.BaekJoon.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2003 수들의 합 2
내풀이 : 하나 원소를 기준으로 그 다음 원소들 완전 탐색, 조건 주의
>> 투포인터 문제였음
 */
public class B2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            int sum = arr[i];
            if(sum == m) {
                result++;
                continue;
            }
            for(int j = i+1; j < n; j++){
                sum += arr[j];
                if(sum == m){
                    result++;
                    break;
                } else if (sum > m)
                    break;
            }
        }
        System.out.println(result);
    }

    //투포인터 풀이
    static int twoPointer(int[] arr, int m){
        int count = 0;
        int startPoint = 0, endPoint = 0;
        int len = arr.length;
        int sum = 0;

        while(true){
            //값을 줄여서 m에 맞춰야 하므로, 현재 startIndex의 값을 빼고 한 칸 앞으로 이동
            if(sum >= m){
                sum -= arr[startPoint++];
            } else if (endPoint >= len) {
                break;
            }else{ //값을 늘려 M을 맞춰야 하므로 현재 endIdx를 한칸 뒤로 이동
                sum += arr[endPoint++];
            }

            if(sum == m){
                count++;
            }
        }

        return count;
    }
}
