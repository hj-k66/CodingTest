package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 빙빙 돌며 사각형 채우기
 */
public class SnailAlphabetSquare {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        boolean[][] isChecked = new boolean[n][m];
        char alphabet = 'A';
        int dir = 0;
        int[] dx = new int[]{0, 1, 0, -1}; // 우, 하, 좌, 상
        int[] dy = new int[]{1, 0, -1, 0};
        int total = n*m;
        int x = 0;
        int y = 0;
        grid[x][y] = alphabet;
        isChecked[x][y] = true;
        while(total > 1){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx, ny) && !isChecked[nx][ny]){
                alphabet = (char)('A' + (alphabet - 'A' +1) % 26);
                grid[nx][ny] = alphabet;
                isChecked[nx][ny] = true;
                x = nx;
                y = ny;
                total--;
            }else{
                dir = (dir + 1) % 4;
            }
        }

        //출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
