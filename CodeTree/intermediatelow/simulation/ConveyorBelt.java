package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 밀고 당기기 / 컨베이어 벨트
 */
public class ConveyorBelt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2][n];
        //첫번째줄 입력
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            arr[0][j] = Integer.parseInt(st.nextToken());
        }
        //두번째줄 입력
        st = new StringTokenizer(br.readLine());
        for(int j = n - 1; j >= 0; j--){
            arr[1][j] = Integer.parseInt(st.nextToken());
        }

        //로직
        while(t-- > 0){
            //첫번째 줄
            int temp1 = arr[0][n-1];
            for(int col = n-1; col > 0; col--){
                arr[0][col] = arr[0][col-1];
            }
            //두번쨰 줄
            int temp2 = arr[1][0];
            for(int col = 0; col < n-1; col++){
                arr[1][col] = arr[1][col+1];
            }
            arr[0][0] = temp2;
            arr[1][n-1] = temp1;
        }

        //출력
        for(int i = 0; i < n; i++){
            System.out.print(arr[0][i] + " ");
        }
        System.out.println();
        for(int i = n - 1; i >= 0; i--){
            System.out.print(arr[1][i] + " ");
        }


    }
}
