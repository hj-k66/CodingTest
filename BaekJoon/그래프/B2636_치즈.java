package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 2636 치즈
12996KB |	96ms
[문제 해석]
- N*M (100*100)
- 빈칸 : 0 , 치즈 : 1
- 가장자리는 빈칸
- 빈칸과 맞닿아 있는 치즈만 녹음
=> 한시간마다 바깥쪽 치즈만 녹음
목표 : 치즈가 모두 녹아 없어지는데 걸리는 시간 & 모두 녹기 한 시간 전에 남아있는 치즈의 칸 수
[문제 풀이]
- 빈칸(0,0)을 기준으로 FloodFill 사용해 탐색 => Flood Fill 진행 중 만나는 치즈가 녹일 치즈
1. 치즈가 0이 될때까지 아래 과정 반복
2. 직전 치즈 칸 수 = 현재까지의 치즈 수 저장
3. 빈칸(0,0)을 시작으로 Flood Fill 진행
    - 빈칸인 경우 : 큐에 넣기
    - 치즈인 경우 : 치즈 녹이기
4. 큐가 다 비었다면 시간 증가
5. 치즈가 0이라면 시간과 치즈 수 출력

[알고리즘]
Flood Fill
- 치즈가 녹을 기준은 치즈 영역의 가장 바깥쪽 치즈이므로, 영역을 구하는 알고리즘인 Flood Fill 사용
=> 특히 치즈의 바깥쪽 == 공기 영역의 바깥쪽 이므로, 빈칸의 영역을 구해 문제 해결

[시간복잡도]
가로*세로*치즈의 갯수 : N*M*K
 */
public class B2636_치즈 {
    static int N;
    static int M;
    static int[][] map;
    static int cheeseCnt;
    static int answerCnt;
    static int answerTime;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheeseCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        //로직
        answerTime = 0;
        while (cheeseCnt != 0) { //치즈가 다 녹을 때까지 진행
            answerCnt = cheeseCnt;  //현재까지의 치즈
            visited = new boolean[N][M];
            BFS();      //Flood Fill 진행
            answerTime++;
        }


        System.out.println(answerTime);
        System.out.println(answerCnt);
    }

    static void BFS() {
        Queue<int[]> q = new ArrayDeque<>();

        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;

                if (map[nx][ny] == 0) { //빈칸
                    q.add(new int[]{nx, ny});
                } else {    //치즈
                    cheeseCnt--;
                    map[nx][ny] = 0;
                }
            }
        }
    }
}

