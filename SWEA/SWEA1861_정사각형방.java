package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[SWEA] 1861 정사각형방
90,932 kb | 523 ms
[문제 해석]
- N*N개의 방, 방에 있는 숫자는 서로 다름
- 상하좌우 이동, 이동하려는 방 숫자 = 현재 방 + 1
=> 목표 : 처음 어떤 수가 적힌 방에 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하기
[문제 풀이]
1. 모든 시작점을 기준으로 이동 가능 횟수를 탐색
    1) 현재 좌표에서 사방 중 이동 가능한 방이 있는지 탐색
    2-1) 이동 가능한 방이 있는 경우
        - 이동 횟수 cnt+1
        - 해당 방으로 이동 -> 1)로 넘어가 탐색 계속 진행
    2-2) 이동 가능한 방이 없는 경우
        - 현재까지의 이동 횟수가 최댓값이라면 갱신
2. 결과 출력
[시간복잡도]
1. 모든 방을 시작점으로 탐색 : O(N^2)
2. 탐색 : 최악의 경우 방 번호가 1씩 증가하면서 한 번의 탐색에서 최대 N^2의 방 방문
=> 따라서 N^2 * N^2 = O(N^4)의 시간복잡도
 */
public class SWEA1861_정사각형방 {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int[][] arr;
    static int answerStart;
    static int answerRoomCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //로직
            answerStart = 0;
            answerRoomCnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    BFS(i,j);
                }
            }

            sb.append('#').append(tc).append(' ').append(answerStart).append(' ').append(answerRoomCnt).append('\n');
        }
        System.out.println(sb);
    }

    static void BFS(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});

        int start = arr[startX][startY];
        int roomCnt = 1;
        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if(!inRange(nx,ny)) continue;
                if(arr[nx][ny] == arr[curr[0]][curr[1]] + 1) {
                    roomCnt++;
                    q.add(new int[]{nx,ny});
                }

            }
        }

        //최댓값
        if(answerRoomCnt < roomCnt){
            answerRoomCnt = roomCnt;
            answerStart = start;
        }
        // 이동할 수 있는 방의 개수가 최대인 방이 여럿이라면, 그 중에서 적힌 수가 가장 작은 것 출력
        if(answerRoomCnt == roomCnt){
            answerStart = Math.min(answerStart, start);
        }

    }

    static boolean inRange(int i, int j){
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    /*
    [재귀 + 메모이제이션]
    - O(N^4)의 시간복잡도를 줄이기 위해 이미 한 번 갔던 경로는 안 가고 바로 계산하기 위해 메모이제이션 도입
     */
    static int[][] memo;
    static void otherSolution(){
        memo = new int[N][N];
        int[] answer = new int[2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int cnt = f(i,j);
                int start = arr[i][j];

                if(answer[1] < cnt || (cnt == answer[1] && answer[0] > start)){
                    answer[0] = start;
                    answer[1] = cnt;
                }
            }
        }

    }

    static int f(int i, int j){
        // 이미 방문한 곳이면 memo 리턴
        if(memo[i][j] > 0) return memo[i][j];

        for(int d = 0; d < 4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];

            // 이동하려는 방 숫자 = 현재 방 + 1
            if(!inRange(nx,ny) || arr[nx][ny]  != arr[i][j]+1) continue;

            return memo[i][j] = f(nx,ny) + 1;
        }
        return memo[i][j] = 1;
    }
}
