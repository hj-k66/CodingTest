package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
[BOJ] 7576 토마토
100664KB |	472ms
[문제해석]
- N,M (2~1000)
- 하루가 지나면 익은 토마토의 상하좌우 토마토는 모두 익음
- 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 빈 칸
** 목표 : 창고에 보관된 토마토들이 다 익게되는 최소 일수

[문제 풀이]
** 여러 정점에서 동시진행 BFS
0. 입력받기 => 익지 않은 토마토의 갯수 저장
1. BFS를 이용해 현재 큐에 있는 모든 익은 토마토의 인접 토마토 확인 (레벨별 BFS)
- 익지 않았으면 익은 걸로 바꾸고, 익지 않은 토마토 갯수--
- 큐에 저장
2. 현재 레별이 끝나면 day++
3, 큐가 비었을 때, 익지 않은 토마토 갯수가 양수면 -1(모두 익지 못하는 상황)
 */
public class B7576_토마토 {
    static int M;
    static int N;
    static int[][] map;
    static int cnt; //안 익은 토마토 갯수
    static Queue<Tomato> q;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Tomato{
        int x;
        int y;

        public Tomato(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = 0;
        q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){ //안 익은 토마토 갯수 세기
                    cnt++;
                }
                if(map[i][j] == 1){ //초기 익은 토마토
                    q.add(new Tomato(i,j));
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);  //이미 모든 토마토가 익어있는 상태
            return;
        }

        //로직
        BFS();
        
    }

    static void BFS(){
        int day = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Tomato curr = q.poll();

                //사방탐색
                for(int d = 0; d < 4; d++){
                   int nx = curr.x + dx[d];
                   int ny = curr.y + dy[d];

                   if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                   if(map[nx][ny] == 0){    //안 익은 토마토인 경우
                       cnt--;
                       map[nx][ny] = 1;
                       q.add(new Tomato(nx,ny));
                   }
                }
            }
            day++;
            if(cnt == 0){   //모든 토마토가 다 익은 경우
                System.out.println(day);
                return;
            }
        }

        //익지 않은 토마토가 있는 경우
        System.out.println(-1);
    }
}
