package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BOJ] 17135 캐슬디펜스
34892KB | 	156ms
[문제 해석]
- NxM(3~15)
- 0 : 빈칸, 1 : 적이 있는 칸
- N+1행에 성 존재
- 성에는 궁수 3명 배치
    - 동시에 모든 궁수 공격
    - 궁수들이 같은 적 공격 가능
    - 거리가 D 이하인 적 중 가장 가깝고, 가장 왼쪽에 있는 적 공격
- 공격이 끝나면 적은 아래로 한 칸 이동
- 모든 적이 성이 있는 칸으로 이동한 경우 게임 종료
** 목표 : 궁수의 공격으로 제거할 수 있는 적의 최대 수

[문제 풀이]
1. 궁수 3명 자리 뽑기 => 조합
    - 0 ~ M-1(열) 중 조합
2. 뽑은 자리를 바탕으로 적 공격
    - BFS를 통해 적 찾기
    - 왜 BFS? : 궁수로부터 가장 가까운 거리의 적을 찾는 것이기 때문
    => 특히 레벨별 BFS 도입
    => 탐색 순서 : 좌 => 상 = > 우 (같은 거리의 경우 가장 왼쪽인 적을 공격해야 하므로)
3. 적 이동 (행 + 1)
    - 전체 행 N+1씩 내리기
    - 0 행에는 빈 배열 할당
4. 모든 적이 N+1까지 올 때까지 2~3번 반복
 */
public class B17135_캐슬디펜스 {
    static int N;
    static int M;
    static int D;
    static int[][] map;
    static int[][] temp;
    static int[] archers;
    static int kill; // 죽인 수
    static int maxKill;

    static int[] dx = {0, -1, 0}; // 좌=>상=>우
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        archers = new int[3];
        comb(0, 0);

        System.out.println(maxKill);
    }

    static void comb(int start, int cnt) {   //궁수 3명 뽑기
        if (cnt == 3) {   // 궁수 3명 뽑기 완료
            // 게임 시작
            arrayCopy();
            game();
            maxKill = Math.max(kill, maxKill);  //현재 궁수 배치에서 죽인 수가 최대라면 갱신
            return;
        }

        for (int i = start; i < M; i++) {
            archers[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    static void game() {
        kill = 0;
        // N만큼 적 이동하면 모든 적 사라지므로 N만큼 반복
        for(int i = 0; i < N; i++){
            // 공격
            shoot();
            // 적 이동
            move();
        }
    }

    static void move(){
        for(int i = N-2; i >= 0; i--){
            temp[i+1] = temp[i];
        }
        temp[0] = new int[M];
    }

    static void shoot() {
        List<int[]> enemies = new ArrayList<>();  // 죽일 적의 위치 저장

        A:
        for (int archerC : archers) {
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visisted = new boolean[N][M];

            q.offer(new int[]{N - 1, archerC});   //시작 정보 : 궁수 바로 위에 있는 좌표
            visisted[N - 1][archerC] = true;

            int depth = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int[] curr = q.poll();

                    //적이면 적의 위치 저장 후 다음 궁수로 넘어감
                    if (temp[curr[0]][curr[1]] == 1) {
                        enemies.add(curr);
                        continue A;
                    }

                    //좌=>상=>우로 이동
                    for(int d = 0; d < 3; d++){
                        int nx = curr[0] + dx[d];
                        int ny = curr[1] + dy[d];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(visisted[nx][ny]) continue;
                        if(depth + 1 > D) continue;     // 궁수로부터의 거리가 D를 초과

                        q.offer(new int[]{nx, ny});
                        visisted[nx][ny] = true;
                    }
                }
                depth++;    //거리 증가
            }
        }

        // 적 죽이기
        for(int[] e : enemies){
            if(temp[e[0]][e[1]] != 1) continue;  // 이미 죽인 적

            temp[e[0]][e[1]] = 0;
            kill++;
        }
    }

    static void arrayCopy() {
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, temp[i], 0, M);
        }
    }


}
