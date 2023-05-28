package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
[BOJ] 2667 단지번호붙이기
내풀이 : 각 좌표 모두 검사 >> 상하좌우 dfs로 탐색
 */

public class B2667 {
    static int[][] map;
    static boolean[][] visited;
    static int count; //단지에 속하는 집의 수
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < n; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        //로직
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 & !visited[i][j]){
                    count = 1;
                    dfs(i,j);
                    result.add(count);
                }
            }
        }
        //결과
        Collections.sort(result);
        System.out.println(result.size());
        for (int num: result) {
            System.out.println(num);
        }

    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newY >= 0 && newX < n && newY < n){
                if(map[newX][newY] == 1 && !visited[newX][newY]){
                    dfs(newX, newY);
                    count++;
                }
            }
        }
    }
}
