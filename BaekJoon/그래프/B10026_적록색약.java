package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
[BOJ] 10026 적록색약
13052KB |	80ms
[문제 해석]
- NxN(100x100)
- 같은 구역 : 같은 색 상하좌우 인접
- 적록 색약 : 빨간색 == 초록색
**목표 : 적록색약인 사람과 아닌 사람이 봤을 때 구역의 수
[문제 풀이]
1. 모든 점을 시작으로 BFS 수행
- 이미 방문한 지점은 pass
2. 사방탐색 진행
    - 같은 색이면 탐색 계속 진행
    - 적록색약이면 빨간색==초록색
    - 적록색약이든 아니든 같은 함수를 쓰기 위해 매개변수로 적록색약 여부 넘김
[다른 풀이]
- 적록색약이 아닌 사람 코드에서 초록색을 모두 빨강색으로 변경
 */
public class B10026_적록색약 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    static int colorBlindCnt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Color{
        int x;
        int y;

        public Color(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        //로직
        cnt = 0;
        colorBlindCnt = 0;
        visited = new boolean[N][N];
        // 적록색약이 아닌 사람
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                BFS(i,j, false);
                cnt++;
            }
        }

        //적록색약인 사람
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                BFS(i,j, true);
                colorBlindCnt++;
            }
        }

        System.out.println(cnt + " " + colorBlindCnt);
    }

    static void BFS(int x, int y, boolean isBlind){
        Queue<Color> q = new ArrayDeque<>();
        q.add(new Color(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Color curr = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if(map[nx][ny] == map[curr.x][curr.y] || (isBlind && map[nx][ny] != 'B'&& map[curr.x][curr.y] != 'B')){
                    visited[nx][ny] = true;
                    q.add(new Color(nx,ny));
                }

            }
        }
    }

    static void DFS(int x, int y, int color){
        visited[x][y] = true;

        //사방
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(visited[nx][ny]) continue;

            if(color != map[nx][ny]) continue;
            DFS(nx,ny,map[nx][ny]);
        }

    }
}
