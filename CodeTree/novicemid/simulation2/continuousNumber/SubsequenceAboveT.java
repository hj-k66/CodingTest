package CodingTest.CodeTree.novicemid.simulation2.continuousNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 최장 연속 부분 수열 / T를 초과하는 연속 부분 수열
 */
public class SubsequenceAboveT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > t){
                cnt++;
            }else{
                max = Math.max(cnt, max);
                cnt = 0;
            }
        }
        System.out.println(Math.max(cnt, max));
    }
}
