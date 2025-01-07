package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[SWEA] 1954 달팽이 숫자
18,396 kb | 103 ms
[문제 풀이]
경계를 만나면, 방향 전환
 */
public class SWEA1954_달팽이숫자 {
    static int[] dx = {0,1,0,-1}; // 우, 하, 좌, 상
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            int row = 0;
            int col = 0;
            int d = 0;
            for(int num = 1; num <= N*N; num++){
                snail[row][col] = num;
                int newX = row + dx[d];
                int newY = col + dy[d];
                // 경계 벗어나면 방향 전환
                // 이미 값이 채워져 있다면 방향 전환
                if(newX < 0 || newX >= N || newY < 0 || newY >= N || snail[newX][newY] != 0){
                    d = (d+1)%4;
                }

                row += dx[d];
                col += dy[d];
            }

            //출력
            sb.append('#').append(t).append('\n');
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sb.append(snail[i][j]).append(' ');
                }
                sb.append('\n');
            }

        }
        System.out.println(sb);
    }
    /*
    한 방향 당 일정 cnt만큼 2줄씩 찍히는 규칙
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            int row = 0;
            int col = -1;
            int d = 0;

            //맨윗줄
            int num;
            for(num = 1; num <= N; num++){
                row += dx[d];
                col += dy[d];
                snail[row][col] = num;
            }
            //방향 전환
            d++;

            // 한 방향 당 cnt만큼 2줄씩 찍히기
            // cnt는 N-1부터 점점 감소
            for(int cnt = N-1; cnt >= 1; cnt--){
                for(int i = 0; i < 2; i++){
                    for(int j = 0; j < cnt; j++){
                        row += dx[d];
                        col += dy[d];
                        snail[row][col] = num++;
                    }
                    d = (d+1)%4;
                }
            }

            //출력
            sb.append('#').append(t).append('\n');
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sb.append(snail[i][j]).append(' ');
                }
                sb.append('\n');
            }

        }
        System.out.println(sb);
    }
}
