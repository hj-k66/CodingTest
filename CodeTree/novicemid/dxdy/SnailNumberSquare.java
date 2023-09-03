package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 빙빙 돌며 숫자 사각형 채우기
 */
public class SnailNumberSquare {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] answer = new int[n][m];
        int[] dx = new int[]{0, 1, 0, -1};//우하왼상
        int[] dy = new int[]{1, 0, -1, 0};
        int curDir = 0;
        int x = 0;
        int y = 0;
        answer[x][y] = 1;
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[curDir];
            int ny = y + dy[curDir];
            if (!inRange(nx, ny) || answer[nx][ny] != 0) {
                curDir = (curDir + 1) % 4;
            }
            x += dx[curDir];
            y += dy[curDir];
            answer[x][y] = i;
        }

        //출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
