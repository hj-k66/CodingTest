package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
[BOJ] 11651 좌표 정렬하기 2
내풀이 : 11650 문제와 유사, compareTo 조건만 다르게 함.
 */
public class B11651 {
    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if(this.y == o.y)
                return this.x - o.x;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Coordinate coordinate = new Coordinate(x,y);
            coordinates.add(coordinate);
        }

        Collections.sort(coordinates);

        for (Coordinate co: coordinates) {
            sb.append(co.x).append(" ").append(co.y).append("\n");
        }
        System.out.print(sb);
    }
}
