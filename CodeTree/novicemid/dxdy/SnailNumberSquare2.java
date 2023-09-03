package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 빙빙 돌며 숫자 사각형 채우기 2
 */
public class SnailNumberSquare2 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int num = 1;
        int dir = 0;
        int[] dx = new int[]{1, 0, -1, 0};//아래, 오, 위, 왼
        int[] dy = new int[]{0, 1, 0, -1};
        int x = 0; int y = 0;
        arr[x][y] = num;
        while (num < n * m) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx, ny) && arr[nx][ny] == 0){
                num++;
                arr[nx][ny] = num;
                x = nx;
                y = ny;
            }else{
                dir = (dir + 1) % 4;
            }
        }

        //출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
