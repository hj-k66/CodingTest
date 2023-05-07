package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
[BOJ] 11650 좌표 정렬하기
내풀이 : 좌표 클래스 선언 >> Comparable 이용해 x로 sort, x가 같을 경우, y로 sort
System.out.println으로 일일이 출력하니 시간초과 >> StringBuilder로 한번에 출력
 */
public class B11650 {
    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb  = new StringBuilder();
        ArrayList<Coordinate> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Coordinate coordinate = new Coordinate(x,y);
            arr.add(coordinate);
        }

        Collections.sort(arr);

        for (Coordinate co :arr) {
            sb.append(co.x).append(" ").append(co.y).append('\n');
        }
        System.out.print(sb);
    }
}
