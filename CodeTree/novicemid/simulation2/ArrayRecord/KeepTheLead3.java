package CodingTest.CodeTree.novicemid.simulation2.ArrayRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 배열 기록 / 선두를 지켜라 3
 */
public class KeepTheLead3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[1000001];
        int timeA = 1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            while(t-- > 0){
                arrA[timeA] = arrA[timeA-1] + v;
                timeA++;
            }
        }
        int[] arrB = new int[1000001];
        int timeB = 1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            while(t-- > 0){
                arrB[timeB] = arrB[timeB-1] + v;
                timeB++;
            }
        }

        //명예의 전당 조합 계산

        int ans = 0;
        int leader = 0;
        for(int i = 1; i < timeA; i++){
            if(arrA[i] > arrB[i]){
                if(leader != 1){
                    ans++;
                    leader = 1;
                }
            } else if (arrA[i] < arrB[i]) {
                if(leader != 2){
                    ans++;
                    leader = 2;
                }
            }else{
                if(leader != 3){
                    ans++;
                    leader = 3;
                }
            }
        }
        System.out.println(ans);
    }
}
