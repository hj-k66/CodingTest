package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 4963 섬의 개수
내풀이 : 대각선 포함이므로 8개의 방향 조사
 */
public class B4963 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0 ,0, -1,1, -1, 1};
    static int[] dy = {0,0, -1, 1,  -1, 1,1, -1};
    static int count;
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;
            for(int i = 0 ; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            //로직
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if (map[i][j] == 1 & !visited[i][j]) {
                        count++;
                        dfs(i,j);

                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newY >= 0 && newX < h && newY < w){
                if(map[newX][newY] == 1 & !visited[newX][newY]){
                    dfs(newX, newY);
                }
            }
        }
    }
}
