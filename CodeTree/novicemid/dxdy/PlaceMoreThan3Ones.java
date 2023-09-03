package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlaceMoreThan3Ones {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dx = new int[]{0, 0, -1, 1}; //우하좌상
        int[] dy = new int[]{1, -1, 0, 0};
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int curCnt = 0;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k]; int ny = j + dy[k];
                    if(inRange(nx, ny) && grid[nx][ny] == 1){
                        curCnt++;
                    }
                }
                if(curCnt >= 3) result++;
            }
        }

        System.out.println(result);
    }
    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
