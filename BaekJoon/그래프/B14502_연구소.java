package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 14502 연구소
68260KB |	228ms
[문제 해석]
- N*M (3 ~ 8)
- 0 : 빈칸, 1 : 벽, 2 : 바이러스
- 바이러스는 모든 상하좌우 인접한 빈 칸으로 퍼짐
- 벽을 3개 세움
- 바이러스가 퍼지지 않은 곳(빈칸)의 안전 영역의 크기의 최댓값 구하기
[문제 풀이]
1. 조합을 통해 벽 세우기
   - 2차원 배열 조합으로 3개 뽑기
2. 바이러스 퍼뜨리기
    - 배열 복사해서 바이러스 퍼뜨리기
    - BFS 사용
    - 빈칸 갯수-- 하면서 안전영역 동시에 구하기
3. 안전영역 최댓값으로 업데이트
 */
public class B14502_연구소 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] spreadMap;
    static List<int[]> virus = new ArrayList<>();

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int safeArea;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        spreadMap = new int[N][M];
        safeArea = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[]{i,j});
                if(map[i][j] == 0) safeArea++;
            }
        }

        answer = 0;
        comb(0,0);

        System.out.println(answer);
    }

    static void comb(int start, int idx){
        if(idx == 3){ //  벽 3개 다 세웠을 때
            // 바이러스 퍼뜨리기
            int tempSafe = spreadVirus();
            answer = Math.max(tempSafe, answer);
            return;
        }

        for(int i = start; i < N*M; i++){
            int x = i / M;  //행
            int y = i % M;  //열

            if(map[x][y] != 0) continue;    //빈칸이 아닐 경우, 넘기기

            map[x][y] = 1;  //벽 세우기
            comb(i+1, idx+1);
            map[x][y] = 0; // 되돌리기
        }
    }

    static int spreadVirus(){
        // 배열 복사
        arrayCopy();

        int tempSafe = safeArea - 3;

        Queue<int[]> q = new ArrayDeque<>();
        for(int[] v : virus){
            q.add(v);
        }

        //BFS
        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(spreadMap[nx][ny] != 0) continue;    //빈칸이 아니면 넘어가기

                spreadMap[nx][ny] = 2;
                q.add(new int[]{nx,ny});
                tempSafe--;
            }
        }

        return tempSafe;
    }

    static void arrayCopy(){
        for(int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, spreadMap[i], 0, M);
    }
}
