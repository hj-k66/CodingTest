package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[CodeTree] dx dy technique / 가운데에서 시작하여 빙빙 돌기
 */
public class SnailStartFromCenter {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] dx = new int[]{0, -1, 0, 1}; // 오, 위, 왼, 아래
        int[] dy = new int[]{1, 0, -1, 0};
        int num = 1;
        int dir = 0;
        int x = n / 2; int y = n / 2;
        int curN = 1;
        arr[x][y] = num;
        while (num < n * n){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx, ny, curN) && arr[nx][ny] == 0){
                if(nx == n/2 + curN && ny == nx){
                    curN++;
                }
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
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }



    static boolean inRange(int x, int y, int curN){
        return n / 2 - curN <= x && x <= n / 2 + curN &&
                n / 2 - curN <= y && y <= n / 2 + curN;
    }
}
