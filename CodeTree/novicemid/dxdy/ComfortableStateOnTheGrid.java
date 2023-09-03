package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 격자 위의 편안한 상태
 */
public class ComfortableStateOnTheGrid {
    static int[][] grid;
    static int n;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grid[r][c] = 1;
            if(isComfortable(r, c)) System.out.println(1);
            else System.out.println(0);
        }
    }

    static boolean isComfortable(int r, int c) {
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(InRange(nx, ny) && grid[nx][ny] == 1){
                cnt++;
            }
        }
        return cnt == 3;
    }

    static boolean InRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
}
