package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2615 오목
- 현재 값에서 이전값 체크 필요 -> 범위 내에 있으면서, 현재 값(바둑알)과 동일하면 pass
 */
public class B2615 {

    private static boolean inRange(int x, int y){
        return 1 <= x && x<= 19 && 1 <= y && y <= 19;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = 19;
        int[][] grid = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = new int[]{-1,0,1,1};
        int[] dy = new int[]{1,1,1,0};

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int curr = grid[i][j];
                if(curr != 0) {
                    for (int d = 0; d < 4; d++) {
                        //이전값 체크
                        int prevX = i - dx[d];
                        int prevY = j - dy[d];
                        if (inRange(prevX, prevY) && curr == grid[prevX][prevY])
                            continue;
                        int x = i;
                        int y = j;
                        int cnt = 1;
                        while (true) {
                            x += dx[d];
                            y += dy[d];
                            if (!inRange(x, y))
                                break;
                            if (grid[x][y] != curr)
                                break;

                            if (++cnt > 5)
                                break;
                        }
                        if (cnt == 5) {
                            System.out.println(curr);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
