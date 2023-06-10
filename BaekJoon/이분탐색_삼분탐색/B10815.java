package CodingTest.BaekJoon.이분탐색_삼분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
[BOJ] 10815 숫자 카드
내풀이 : 이분탐색으로 해결
 */
public class B10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sangCard = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            sangCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sangCard);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target,sangCard)).append(" ");
        }

        System.out.println(sb);
    }

    //이분탐색
    static int binarySearch(int target, int[] arr){
        int startIdx = 0;
        int endIdx = arr.length - 1;
        while(startIdx <= endIdx){
            int midIdx = (startIdx + endIdx) / 2;
            if(arr[midIdx] > target){
                endIdx = midIdx-1;
            } else if (arr[midIdx] < target) {
                startIdx = midIdx + 1;
            }else {
                return 1;
            }
        }
        return 0;
    }
}
