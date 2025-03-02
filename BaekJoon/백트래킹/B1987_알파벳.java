package CodingTest.BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 1987 알파벳
12444KB |	864ms

[문제 해석]
목표 : 좌측 상단에서 시작해 말이 최대 몇 칸 지날 수 있는지
- R*C (1~20)
= 말은 상하좌우로 이동 가능
- 같은 알파벳이 적힌 칸을 2번 지날 수 없음

[문제 풀이]
1. 알파벳 방문 여부는 boolean[] 배열로 처리
    - 인덱스가 알파벳이 되게
    - boolean[] alphabet = new boolean['Z' + 1] //'Z'까지의 배열
2. 백트래킹
   - 사방탐색하다가 막히는 경우, 이전 지점으로 돌아가 시도해보지 않았던 다른 방향으로 탐색 시도
   => 재귀함수로 구현
** 이미 알파벳으로 방문 여부를 파악하고 있으므로 추가적인 visited배열은 필요 x
 */

public class B1987_알파벳 {
    static int R;
    static int C;
    static char[][] map;
    static boolean[] alphabet;  //말이 지나간 알파벳 표시
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer;

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
        alphabet = new boolean['Z'+1];
        answer = 0;

        alphabet[map[0][0]] = true;
        DFS(0,0, 1);

        System.out.println(answer);
    }

    /**
     * 현재 좌표(r,c)까지 이동한 칸 수가 최댓값이면 갱신하고,
     * 현재 좌표 기준 사방 중 이동가능한 좌표로 이동 후, 다음 좌표 이동 자체는 재귀로 넘김
     * 알파벳 사용 체크 후 재귀로 이동, 재귀로 이동 끝나면 되돌리기
     * @param r
     * @param c
     * @param distance
     */
    static void DFS(int r, int c, int distance){
        answer = Math.max(answer,distance); //현재좌표까지의 이동횟수가 최대라면 갱신

        //사방탐색
        for(int d = 0; d < 4; d++){
            int nr = r + dx[d];
            int nc = c + dy[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(alphabet[map[nr][nc]]) continue;

            alphabet[map[nr][nc]] = true;   //알파벳 사용 체크
            DFS(nr,nc, distance + 1);
            alphabet[map[nr][nc]] = false;  //사용한 알파벳 되돌리기
        }

    }
}
