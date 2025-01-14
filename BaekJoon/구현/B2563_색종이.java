package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2563 색종이
11624KB |	68ms
[문제 풀이]
- boolean배열을 이용해 겹치는 곳을 파악하고, 한칸한칸의 넓이를 합하는 방식으로 구한다.
- visited[x][y] = true : 좌표 (x,y)에 색종이가 붙어 있다.
=> 최대 크기가 100*100이기 때문에 단순 완탐으로 가능
 */
public class B2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[100][100];

        int answer = 0;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
