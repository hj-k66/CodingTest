package CodingTest.BaekJoon.구현;

import java.io.*;
import java.util.*;

//	35904kb |	208ms
public class B17135 {
    static int N;
    static int M;
    static int D;
    static int[] archer;
    static int[][] origin;
    static boolean[][] dead;
    static int answer;
    static int max;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        map = new int[N][M];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        archer = new int[3];
        // 궁수 3명 뽑기
        comb(0, 0);

        System.out.println(answer);


    }

    static void comb(int idx, int start) {
        if (idx == 3) {
            //뽑은 궁수 자리로 게임 시작
            max = 0;
            makeTemp();
            play(archer);

            return;

        }

        for (int i = start; i < M; i++) {
            archer[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    private static void makeTemp() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(origin[i], 0, map[i], 0, M);
        }
    }

    static void play(int[] archer) {
        // 현재 궁수의 좌표 바로 위의 가장 왼쪽부터 적이 있는지 탐색
        //거리가 D이하이고 가장 왼쪽에 있는 적
        // 0~2번 궁수까리 죽일 타겟 고르기

        int turn = N;
        while (turn > 0) {
            BFS();
            move(); //적 이동
            turn--;
        }
        answer = Math.max(answer, max);

    }

    static void move() {
        for (int i = N - 2; i >= 0; i--) {
            map[i + 1] = map[i];  //아래로 내리기
        }
        map[0] = new int[M];
    }

    static int[] dx = {0, -1, 0}; //좌 ->상 -> 우
    static int[] dy = {-1, 0, 1};

    static void BFS() {
        dead = new boolean[N][M];
        A:for (int ar : archer) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visit = new boolean[N][M];

            queue.offer(new int[]{N - 1, ar});
            visit[N - 1][ar] = true;

            int distance = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] curr = queue.poll();

                    if (map[curr[0]][curr[1]] == 1) { //적이면
                        dead[curr[0]][curr[1]] = true;
                        continue A; // 다음 궁수 탐색
                    }

                    for (int d = 0; d < 3; d++) {
                        int nx = curr[0] + dx[d];
                        int ny = curr[1] + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;    //경계벗어남
                        }
                        if (visit[nx][ny]) {
                            continue;
                        }
                        if (distance + 1 > D) {
                            continue;
                        }

                        queue.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;

                    }
                }
                distance++;
            }


        }

        // 적 죽이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dead[i][j]) {
                    map[i][j] = 0;
                    max++;
                }
            }
        }


    }
}
