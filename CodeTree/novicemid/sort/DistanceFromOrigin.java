package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DistanceFromOrigin {
    static class Point implements Comparable<Point>{
        private int x;
        private int y;
        private int number;

        public Point(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        @Override
        public int compareTo(Point o) {
            int distanceO = Math.abs(o.x) + Math.abs(o.y);
            int distance = Math.abs(this.x) + Math.abs(this.y);
            if(distance == distanceO){
                return this.number - o.number;
            }
            return distance - distanceO;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1);
        }

        Arrays.sort(points);

        for(int i = 0; i < n; i++){
            System.out.println(points[i].number);
        }
    }
}
