package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 이동경로상에 있는 모든 숫자 더하기
 */
public class AddAllTheNumbersOnThePath {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        String commands = br.readLine();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        int[] dx = new int[]{-1, 0, 1, 0};//북, 동, 남, 서
        int[] dy = new int[]{0, 1, 0, -1};
        int dir = 0;
        int x = n / 2;
        int y = n / 2;
        int total = grid[x][y];
        for (int i = 0; i < t; i++) {
            char c = commands.charAt(i);
            if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(inRange(nx, ny)){
                    total += grid[nx][ny];
                    x = nx;
                    y = ny;
                }
            }

        }
        System.out.println(total);
    }
    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
