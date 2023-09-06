package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 밀고 당기기 / 삼각형 컨베이어 벨트
 */
public class ConveyorBeltTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr3[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        while(t-- > 0){
            int temp1 = arr1[n-1];
            for(int i = n - 1; i > 0; i--){
                arr1[i] = arr1[i-1];
            }
            int temp2 = arr2[n-1];
            for(int i = n - 1; i > 0; i--){
                arr2[i] = arr2[i-1];
            }
            int temp3 = arr3[n-1];
            for(int i = n - 1; i > 0; i--){
                arr3[i] = arr3[i-1];
            }
            arr1[0] = temp3;
            arr2[0] = temp1;
            arr3[0] = temp2;
        }

        //출력
        for(int i = 0; i < n; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(arr3[i] + " ");
        }
    }
}
