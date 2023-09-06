package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 단일 객체를 이동 / 떨어지는 1자 블록
 */
public class FallingHorizontalBlock {
    static int[][] arr;
    static int k;
    static int m;

    static boolean isBlocked(int row, int col){
        for (int i = row; i >= 0; i--) {
            if (arr[i][col] == 1) return true;
        }
        return false;
    }


    static boolean canDrop(int row) {
        for (int col = k - 1; col <= k + m - 2; col++) {
            if (arr[row][col] == 1 || isBlocked(row - 1, col)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        //바닥부터 확인
        for (int row = n - 1; row >= 0; row--) {
            if(canDrop(row)){
                for (int col = k - 1; col <= k + m - 2; col++) {
                    arr[row][col] = 1;
                }
                break;
            }
        }

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
