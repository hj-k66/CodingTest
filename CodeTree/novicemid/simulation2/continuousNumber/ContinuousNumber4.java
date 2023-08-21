package CodingTest.CodeTree.novicemid.simulation2.continuousNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[CodeTree] 최장 연속 부분 수열 / 연속되는 수 4 (증가하는 연속 부분 수열)
 */
public class ContinuousNumber4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i == 0 || arr[i] > arr[i-1]){
                cnt++;
            }else{
                max = Math.max(cnt, max);
                cnt = 1;
            }
        }

        System.out.println(Math.max(cnt, max));
    }
}
