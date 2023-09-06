package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 여러 객체를 이동 / 숫자가 가장 큰 인접한 곳으로 동시에 이동
 */
public class MoveToMaxAdjacentCellSimultaneously {
    static int[][] arr;
    static int n;
    static int[][] next;

     static void removeOverlapping() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(next[i][j] >= 2) next[i][j] = 0;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    //2. 1인 위치에서 상하좌우 탐색 >> 가장 큰곳(가장 큰곳이 여러곳이면 상하좌우 우선순위로)
    static void findMax(int row, int col) {
        int[] dx = new int[]{-1, 1, 0, 0,};//상하좌우
        int[] dy = new int[]{0, 0, -1, 1};
        int nextX = 0;
        int nextY = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (inRange(nx, ny) && max < arr[nx][ny]) {
                nextX = nx;
                nextY = ny;
                max = arr[nx][ny];
            }
        }
        //3. 다음 이동하는 좌표 nextCount에 기록
        next[nextX][nextY] += 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //구슬 시작 위치 입력
        int[][] count = new int[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            count[r - 1][c - 1] = 1;
        }
        next = new int[n][n];

        while (t-- > 0) {
            //0. Next초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    next[i][j] = 0;
                }
            }
            //1. count 탐색하면서 1인 위치
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] == 1) {
                        //2. 1인 위치에서 상하좌우 탐색 >> 가장 큰곳(가장 큰곳이 여러곳이면 상하좌우 우선순위로)
                        //3. 다음 이동하는 좌표 nextCount에 기록
                        findMax(i, j);
                    }
                }
            }
            //4. count 탐색 다 끝났으면 next에서 2 이상인 것 제거
            removeOverlapping();
            // 5. NextCount를 count에 복사
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    count[i][j] = next[i][j];
                }
            }
        }
        //남아있는 구슬 수 출력
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result += count[i][j];
            }
        }
        System.out.println(result);
    }

}
