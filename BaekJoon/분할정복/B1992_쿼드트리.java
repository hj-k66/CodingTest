package CodingTest.BaekJoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 1992 쿼드트리
12552KB |	72ms
[문제 풀이]
*분할정복 알고리즘
재귀로 사이즈를 N/2씩 줄여가며 압축
 */
public class B1992_쿼드트리 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        //로직
        System.out.println(rec(0,0,N));
    }

    /**
     * 시작점을 (r,c)로 하는 구역의 크기가 size인 압축 결과 반환
     * @param r 현재 구역 왼쪽 상단 좌표 행값
     * @param c 현재 구역 왼쪽 상단 좌표 열값
     * @param size 현재 구역의 크기
     * @return
     */
    static String rec(int r, int c, int size){
        char temp = map[r][c];
        for(int i = r; i < r+size; i++){
            for(int j = c; j < c + size; j++){
                if(map[i][j] != temp){  //현개 구역이 모두 같은 숫자가 아니라면
                    //왼쪽 위
                    String leftUp = rec(r,c,size/2);
                    // 오른쪽 위
                    String rightUp = rec(r, c+size/2, size/2);
                    //왼쪽 아래
                    String leftDown = rec(r + size/2,c,size/2);
                    // 오른쪽 아래
                    String rightDown = rec(r+size/2, c + size/2, size/2);

                    return '(' + leftUp + rightUp + leftDown + rightDown + ')';
                }
            }
        }
        return String.valueOf(temp);    //현재 구역이 모두 같은 숫자
    }
}
