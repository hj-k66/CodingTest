package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 3109 빵집
46756KB |	264ms
[문제 풀이]
* 각 행마다 파이프라인 설치 시도
* 시뮬레이션을 해본 결과,방향에 우선순위가 존재
=> 우상 -> 우> 우하
=> 특정 행에서 특정 방향으로 파이프라인 설치 성공한 경우, 남아있는 시도 하지 않고, 해당 행의 파이프라인 설치 종료
=> 파이프라인 설치를 시도하다가 실패한 경우(맵에 이미 파이프 표시한 경우), 실패한 과정에서 표시한 파이프 정보를 되돌릴 필요 없음.(다음 행에서 해도 어차피 안됨)
[시간복잡도]
- 다시 되돌아오는 것이 없기 때문에 맵의 크기인 500*10000 = 500만
 */
public class B3109_빵집 {
    static char[][] map;
    static int R;
    static int C;
    static int answer;

    static int[] dx = {-1,0,1};//  대각선 위, 직선, 대각선 아래
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        //로직
        // 1. 각 행에 대한 파이프라인 설치 시도
        answer = 0;
        for(int i = 0; i < R; i++){
            if(setPipe(i,0)) answer++;
        }
        System.out.println(answer);

    }

    /**
     * boolean : 현재 정점(r,c) 에서  기준으로 파이프 설치 가능한지 판단
     * @param r
     * @param c
     * @return
     */
    static boolean setPipe(int r, int c){
        // 3. 마지막 열에 도달했다면 파이프라인 설치 성공
        if(c == C-1){
            return true;
        }
        // 2. 세가지 방향으로 파이프 설치하기
        // 방향의 우선순위 : 대각선 위, 직진, 대각선 아래
        for(int d = 0; d < 3; d++){
            // 현재 선택된 방향의 다음 좌표
            int nr = r + dx[d];
            int nc = c + 1;

            // 경계를 벗어나거나 빈 칸이 아니라면 다음 방햩
            if(!inRange(nr,nc) || map[nr][nc] != '.') continue;
            map[nr][nc] = '-';  // 파이프 설치

            // 다음 좌표 기준 세 방향에 대한 파이프 설치 시도는 재귀로 넘김
            if(setPipe(nr,nc)) return true; //여기서 Return을 하면 다음 방향을 판단 x
        }

        return false;

    }


    static boolean flag;
    static void setPipe2(int r, int c){
        if(c == C-1){
            flag = true;
            answer++;
            return;
        }

        for(int d = 0; d < 3; d++){
            int nr = r + dx[d];
            int nc = c + 1;

            if(!inRange(nr,nc) || map[nr][nc] != '.') continue;
            map[nr][nc] = '-';

            setPipe2(nr,nc);
            if(flag) return;
        }
    }

    static boolean inRange(int r, int c){
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
