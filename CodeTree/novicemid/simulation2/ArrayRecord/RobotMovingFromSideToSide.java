package CodingTest.CodeTree.novicemid.simulation2.ArrayRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 배열 기록 / 좌우로 움직이는 로봇
 */
public class RobotMovingFromSideToSide {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrA = new int[1000000];
        int timeA = 1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            if(d.equals("L")){
                while(t-- >0){
                    arrA[timeA] = arrA[timeA-1] -1;
                    timeA++;
                }
            }else{
                while(t-- >0){
                    arrA[timeA] = arrA[timeA-1] + 1;
                    timeA++;
                }
            }
        }
        for(int i = timeA-1; i < arrA.length; i++){
            arrA[i] = arrA[timeA-1];
        }
        int[] arrB = new int[1000000];
        int timeB = 1;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            if(d.equals("L")){
                while(t-- >0){
                    arrB[timeB] = arrB[timeB-1] -1;
                    timeB++;
                }
            }else{
                while(t-- >0){
                    arrB[timeB] = arrB[timeB-1] + 1;
                    timeB++;
                }
            }
        }
        for(int i = timeB-1; i < arrB.length; i++){
            arrB[i] = arrB[timeB-1];
        }
        //같은 위치 경우의 수
        int ans = 0;
        for(int i = 2; i < 1000000; i++){
            if(arrA[i] == arrB[i] && arrA[i-1] != arrB[i-1]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
