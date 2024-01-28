package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2669. 직사각형 네개의 합집합의 면적 구하기
내풀이 : 2차원 배열로 x,y 좌표를 기록 -> 이미 1인 부분은 중복이라는 의미이므로, 1이 아닐 때 넓이 계산
 */
public class B2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] grid = new int[101][101];
        int answer = 0;
        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    if(grid[x][y] != 1) {
                        grid[x][y] = 1;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
