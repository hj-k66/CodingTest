package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 완전 탐색 / 행복한 수열의 개수
 */
public class NumberOfHappySequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //로직
        int result = 0;
        //가로수열
        for (int i = 0; i < n; i++){
            int count = 1;
            int max = 1;
            for(int j = 0; j < n-1; j++){
                if(grid[i][j] == grid[i][j+1]){
                    count++;
                    if(max < count){
                        max = count;
                    }
                }else{
                    count = 1;
                }
            }
            if(max >= m) result++;
        }
        //세로수열
        for(int col = 0; col < n; col++){
            int count = 1;
            int max = 1;
            for(int row = 0; row < n-1; row++){
                if(grid[row][col] == grid[row+1][col]){
                    count++;
                    if(max < count){
                        max = count;
                    }
                }else{
                    count = 1;
                }
            }
            if(max >= m) result++;
        }
        //결과 출력
        System.out.println(result);
    }
}
