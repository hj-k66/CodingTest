package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 7569 토마토
99088KB |	516ms
[문제 풀이]
- 3차원 BFS
 */
public class B7569_토마토 {
    static int N;
    static int M;
    static int H;
    static int[][][] map;
    static int cnt;
    static Queue<Tomato> q;
    static int[] dx = {-1,1,0,0,0,0};   //뒤, 앞, 좌, 우, 위, 아래
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static class Tomato{
        int x;
        int y;
        int z;

        public Tomato(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        cnt = 0;
        q = new ArrayDeque<>();
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    if(map[i][j][h] == 0){  //안 익은 토마토
                        cnt++;
                    }
                    if(map[i][j][h] == 1){  //익은 토마토
                        q.offer(new Tomato(i,j,h));
                    }
                }
            }
        }

        //로직
        if(cnt == 0){   //토마토가 이미 다 익어있을 때
            System.out.println(0);
            return;
        }

        BFS();
    }

    static void BFS(){
        int day = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Tomato curr = q.poll();

                // 6방 탐색
                for(int d = 0; d < 6; d++){
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];
                    int nz = curr.z + dz[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                    if(map[nx][ny][nz] == 0){
                        map[nx][ny][nz] = 1;
                        cnt--;
                        q.offer(new Tomato(nx,ny,nz));
                    }
                }
            }
            day++;
            if(cnt == 0){
                System.out.println(day);
                return;
            }
        }
        System.out.println(-1);
    }
}
