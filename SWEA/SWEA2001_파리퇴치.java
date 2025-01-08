package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[SWEA] 2001 파리퇴치
18,636 kb | 159 ms
[문제 풀이]
1. 파리채 이동 가능 범위(파리채 시작-왼쪽위 좌표)만큼 배열 순회
2. 시작좌표를 기준으로 해당 영역의 파리 수 구하기
 - for문 순회하면서 파리 수 합 구하기
3. 파리 수 최댓값 갱신
 */
public class SWEA2001_파리퇴치 {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //로직
            int answer = 0;
            for(int i = 0; i <= N-M; i++){
                for(int j = 0; j <= N-M; j++){
                    //시작점이 i,j이고 길이가 M인 구역의 파리의 갯수 구하기
                    answer = Math.max(answer, countFly(i,j));
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static int countFly(int startX, int startY){
        int sum = 0;
        for(int i = startX; i < startX + M; i++){
            for(int j = startY; j < startY + M; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
