package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 16926 배열돌리기 1
31908KB | 	744ms
[문제 풀이]
반시계 방향으로 배열을 돌리는 것을 시계방향으로 돌면서 배열값을 당기는 방식으로 구현
=> 회전수만큼 전체 1회 회전을 반복한다.
 */
public class B16926_배열돌리기1 {

    static int[] dx = {0, 1, 0, -1};   //우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};

    static int N;
    static int M;
    static int R;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
//        otherSolution();
        // 회전 수 만큼 반복
        for (int r = 0; r < R; r++) {
            int cnt = Math.min(N, M) / 2;     // 시작점(상단 꼭짓점) 좌표
            for (int s = 1; s <= cnt; s++) {
                int x = s;
                int y = s;

                int temp = arr[x][y];       //시작점의 값 저장
                int d = 0;
                // 한바퀴 돌때까지 반복 (방향 4번 바뀔 때까지)
                while (d < 4) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    //범위 안에 있다면
                    if (nx >= s && nx <= N - s + 1 && ny >= s && ny <= M - s + 1) {
                        arr[x][y] = arr[nx][ny];    //값 당겨오기
                        x = nx;
                        y = ny;
                    }
                    //범위 밖이라면 방향 전환
                    else {
                        d++;
                    }
                }
                // 저장해놨던 첫번째 값을 시작점 아래에 넣기
                arr[s + 1][s] = temp;

            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    /*
    배열 밀기 방식
    32440KB | 	700ms
    => 문제대로 반시계방향으로 배열을 업데이트 한다.
     */
    static void otherSolution(){
        int[] ddx = {1, 0,-1, 0}; //하, 우, 상, 좌
        int[] ddy = {0, 1, 0, -1};
        // 회전 수 만큼 반복
        for(int i = 0; i < R; i++){
            int cnt = Math.min(N,M) / 2;
            for(int s = 1; s <= cnt; s++){  //시작점
                int x = s;
                int y = s;

                int d = 0;
                int temp = arr[s][s];
                int temp2 = 0;

                while(d < 4){
                    int nx = x + ddx[d];
                    int ny = y + ddy[d];

                    if(nx >= s && nx <= N-s+1 && ny >= s && ny <= M-s+1){
                        temp2 = arr[nx][ny];
                        arr[nx][ny] = temp;
                        temp = temp2;
                        x = nx;
                        y = ny;
                    }
                    else d++;
                }
            }
        }
    }
}
