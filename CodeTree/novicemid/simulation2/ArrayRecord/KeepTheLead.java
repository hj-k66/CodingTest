package CodingTest.CodeTree.novicemid.simulation2.ArrayRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 배열 기록 / 선두를 지켜라
 */
public class KeepTheLead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[1000000];
        int timeA = 1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0; j < t; j++){
                arrA[timeA] = arrA[timeA-1] + v;
                timeA++;
            }
        }

        int[] arrB = new int[timeA+1];
        int timeB = 1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0; j < t; j++){
                arrB[timeB] = arrB[timeB-1] + v;
                timeB++;
            }
        }

        //선두 계산
        int ans = 0;
        for(int i = 2; i < timeA; i++){
            boolean previousLead = arrA[i-1] > arrB[i-1];
            boolean curLead = arrA[i] > arrB[i];
            if(previousLead != curLead){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
