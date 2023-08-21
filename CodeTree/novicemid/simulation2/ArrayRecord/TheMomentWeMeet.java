package CodingTest.CodeTree.novicemid.simulation2.ArrayRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheMomentWeMeet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[1000000];
        int[] arrB = new int[1000000];

        int curA = 1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0; j < t; j++){
                if(d.equals("R")){
                    arrA[curA] = arrA[curA-1] + 1;
                }else{
                    arrA[curA] = arrA[curA-1] - 1;
                }
                curA++;
            }
        }
        int curB = 1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0; j < t; j++){
                if(d.equals("R")){
                    arrB[curB] = arrB[curB-1] + 1;
                }else{
                    arrB[curB] = arrB[curB-1] - 1;
                }
                curB++;
            }
        }

        //마주치는 시간 찾기
        int ans = -1;
        for(int i = 1; i < curA; i++){
            if(arrA[i] == arrB[i] ){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
