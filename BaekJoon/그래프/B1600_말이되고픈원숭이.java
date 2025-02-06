package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 1600 말이 되고픈 원숭이
49868KB |	472ms
[문제풀이]
- 가중치 없는 그래프에서의 최단 거리이므로 BFS 사용
- 말의 이동 횟수가 K번으로 제한되어 있므므로 말 이동 횟수에 따른 방문 체크 배열 필요
- 말 이동(8방 탐색), 원숭이 이동(4방탐색) 각각 수행
 */
public class B1600_말이되고픈원숭이 {
     static class Monkey{
        int x;
        int y;
        int horseCnt;

        public Monkey(int x, int y, int horseCnt){
            this.x = x;
            this.y = y;
            this.horseCnt = horseCnt;
        }
    }
    static int K;
    static int W;
    static int H;
    static int[][] map;
    static int[] dx = {-1,1,0,0, -1,-2,-2,-1,1,2,2,1};
    static int[] dy = {0,0,-1,1,-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        BFS();
    }

    static void BFS(){
        Queue<Monkey> q = new ArrayDeque();
        q.add(new Monkey(0,0,0));
        boolean[][][] visited = new boolean[H][W][K+1];
        visited[0][0][0] = true;
        /*
        1. 말로 이동 (8방)
        2. 원숭이 이동 (4방탐색)
         */
        int answer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Monkey curr = q.poll();
                if(curr.x == H-1 && curr.y == W-1){
                    System.out.println(answer);
                    return;
                }

                int length = (curr.horseCnt == K ? 4 : 12); // 말 이동 다했으면 원숭이만 탐색(4), 아니면 말도 탐색
                // 원숭이&말 이동
                for(int d = 0; d < length; d++){
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];

                    int k = (d>=4 ? curr.horseCnt + 1 : curr.horseCnt);

                    if(!inRange(nx,ny) || map[nx][ny] == 1) continue;

                    if(!visited[nx][ny][k]){
                      q.add(new Monkey(nx,ny,k));
                      visited[nx][ny][k] = true;
                    }
                }
            }
            answer++;
        }
        System.out.println(-1);

    }

    static boolean inRange(int x, int y){
        return 0 <= x && x < H && 0 <= y && y < W;
    }
}
