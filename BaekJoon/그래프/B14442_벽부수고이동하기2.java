package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 14442 벽 부수고 이동하기 2
339212KB |	1264ms
[문제 풀이]
- 가중치없는 그래프에서 최단 거리이므로 BFS 사용
- 벽을 최대 K개까지 부수고 이동할 수 있다 => 벽 부순 횟수별로 방문 배열 필요
- 1. 벽일 때 : 벽 부순 횟수 체크 후 부술 수 있고, 해당 벽 횟수에 방문 한 적 없다면 방문
- 2. 빈칸 일때 : 방문 배열 체크 후 방문
=> 벽 부수고 이동하기 1 문제에서 벽 부수는 횟수만 추가한 형태의 문제
 */
public class B14442_벽부수고이동하기2 {
    static class Node{
        int x;
        int y;
        int cnt;    // 벽 부순 횟수

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //로직
        BFS();
    }

    static void BFS(){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        // 벽 부순 횟수 별 방문 체크 배열
        boolean[][][] visited = new boolean[N][M][K+1];
        visited[0][0][0] = true;

        int dist = 1;   // 최단 경로 (0,0) 포함

        while(!q.isEmpty()){
            int size = q.size();
            //레벨별 BFS
            while(size-- > 0){
                Node curr = q.poll();
                if(curr.x == N-1 && curr.y == M-1){ //정점에 도착했을 때
                    System.out.println(dist);
                    return;
                }

                //사방 탐색
                for(int d = 0; d < 4; d++){
                    int nx = curr.x + dx[d];
                    int ny = curr.y + dy[d];

                    //범위 벗어나면
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    //1. 벽일 때
                    if(map[nx][ny] == 1){
                        if(curr.cnt + 1 <= K && !visited[nx][ny][curr.cnt+1]){  //벽을 뚫을 수 있으면
                            q.add(new Node(nx,ny,curr.cnt + 1));
                            visited[nx][ny][curr.cnt+1] = true;
                        }

                    }else{  //2. 빈 칸일 때
                        if(visited[nx][ny][curr.cnt]) continue;
                        q.add(new Node(nx,ny, curr.cnt));
                        visited[nx][ny][curr.cnt] = true;
                    }
                }
            }
            dist++; //한 레벨이 끝나면 거리+1
        }

        // (N-1, M-1) 에 도달하지 못할 때
        System.out.println(-1);
    }
}
