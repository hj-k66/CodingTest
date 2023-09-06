package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 단일 객체를 이동 / 숫자가 더 큰 인접한 곳으로 이동
 */
public class MoveToLargerAdjacentCell {

    static int n;

    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        r--; c--;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        int[] dx = new int[]{-1, 1, 0, 0};// 상하좌우
        int[] dy = new int[]{0, 0, -1, 1};
        System.out.print(arr[r][c] + " ");
        while(true){
            boolean isMoved = false;
            for(int i = 0; i < 4; i++){
                int nx = r + dx[i];
                int ny = c + dy[i];
                if(inRange(nx,ny) && arr[nx][ny] > arr[r][c]){
                    r = nx;
                    c = ny;
                    System.out.print(arr[r][c] + " ");
                    isMoved = true;
                    break;
                }
            }
            if(!isMoved){
                break;
            }
        }
    }
}
