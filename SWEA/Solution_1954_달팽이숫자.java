package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = new int[]{0, 1, 0,-1};
        int[] dy = new int[]{1, 0, -1,0};
        for(int test = 1; test <= T; test++){
            int n = Integer.parseInt(br.readLine());
            int[][] grid = new int[n][n];
            int x = 0;
            int y = 0;
            int d = 0;
            for(int num = 1; num <= n*n; num++){
                grid[x][y] = num;

                int newX = x + dx[d];
                int newY = y + dy[d];

                //방향바꾸는 경우
                // 1. 경계 벗어난 경우
                // 2. 다음값이 이미 수가 채워진 경우
                if(newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] != 0){
                    d++;
                    d %= 4;
                }
                x += dx[d];
                y += dy[d];
            }

            System.out.println("#" + test);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
