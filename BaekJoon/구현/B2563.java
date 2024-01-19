package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2563. 색종이
 */
public class B2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //색종이 수
        boolean[][] grid = new boolean[101][101];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            for(int j = row; j < row + 10; j++){
                for(int k = col; k < col + 10; k++){
                    grid[k][j] = true;
                }

            }
        }
        int cnt = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(grid[i][j]) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
