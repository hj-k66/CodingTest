package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 2206 벽 부수고 이동하기
95916KB |	600ms
[문제해석]
0 : 이동할 수 있는 곳
1 : 벽
목표 : (1,1) -> (N,M)  최단 경로 (시작하는 칸과 끝나는 칸 포함)
- 벽 한 개까지 부수고 이동 가능
[문제 풀이]
가중치 없는 그래프에서 최단 거리 구하는 문제 => BFS

* 한 정점을 방문했을 때 경우의 수 2가지
1. 벽을 부순 적 있는 상태로 정점 방문
2. 벽을 부순 적이 없는 상태로 정점 방문
=> 방문 처리 시 2가지 따로 처리해야 함.
=> boolean[][][] visited = new boolean[N][M][2]

* BFS 탐색 시, 좌표 뿐만아니라 벽 부순 횟수도 같이 관리해야함.

* 4방 이동 시, 2가지 상황
1. 벽 : 벽을 부순 적이 없다면 벽 부수기를 통해(벽 부순 횟수 조건) 탐색 이어감
2. 빈 칸 : 탐색 이어감
=> 해당 탐색을 반복하다 (N-1, M-1) 좌표에 도달했을 때 BFS 탐색의 깊이 출력
 */
public class B2206_벽부수고이동하기 {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        //로직
        BFS();

    }

    static void BFS() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0));
        boolean[][][] visited = new boolean[N][M][2];   //[0] : 벽 안부수고 이동, 1 : 벽 부수고 이동
        visited[0][0][0] = true;

        int answer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.poll();

                if (curr.x == N - 1 && curr.y == M - 1) { //끝까지 도달한 경우 거리 출력
                    System.out.println(answer);
                    return;
                }

                //4방 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;    //경계 벗어남
                    }

                    if (map[nx][ny] == 1) {   //벽을 만났을 때
                        if (curr.cnt == 1) {
                            continue; //이미 벽을 부순 경우
                        }
                        if (visited[nx][ny][1]) {
                            continue;    //현재 좌표에 방문한 적이 있을 때(벽을 부수고 이동했을 때)
                        }

                        q.add(new Node(nx, ny, 1));
                        visited[nx][ny][1] = true;
                    } else {   //빈칸
                        if (visited[nx][ny][curr.cnt]) {
                            continue;    //벽을 안부수고 이동했을 때 현재 좌표에 방문한 적이 있음
                        }

                        q.add(new Node(nx, ny, curr.cnt));
                        visited[nx][ny][curr.cnt] = true;
                    }
                }
            }
            answer++;   //현재 레벨의 모든 탐색이 끝난 경우 최단거리 +1
        }
        // 탐색이 무사히 끝난 경우, N-1, M-1에 도달하지 못했다는 뜻이므로 -1 출력
        System.out.println(-1);
    }
}
