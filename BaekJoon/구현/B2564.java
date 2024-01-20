package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2564 경비원
- 사각형의 경계만 도는 것이기 때문에 하나의 직선 거리라고 생각
 */
public class B2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int storeCnt = Integer.parseInt(br.readLine());
        int[] map = new int[storeCnt];
        int police = 0;
        for(int i = 0; i < storeCnt + 1; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = 0;
            int d = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if(d == 1) tmp  = location;
            if(d == 2) tmp = m + n + n - location;
            if(d == 3) tmp = n + m + n + m - location;
            if(d == 4) tmp = n + location;
            if(i < storeCnt) map[i] = tmp;
            else police = tmp;
        }
        int answer = 0;
        for(int i = 0; i < storeCnt; i++){
            int path1 = Math.abs(police - map[i]);
            int path2 = 2*n + 2*m - path1;
            answer += Math.min(path1, path2);
        }
        System.out.println(answer);
    }
}
