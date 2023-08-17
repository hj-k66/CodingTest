package CodingTest.CodeTree.novicemid.simulation1.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 구간 칠하기 / 최대로 겹치는 지점
 */

public class MaximumOverlappedPoints {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] points = new int[101];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            //겹치는 지점
            for(int j = x1; j <= x2; j++){
                points[j]++;
            }
        }

        //최대로 겹치는 지점
        int max = 0;
        for (int i = 0; i < 101; i++) {
            max = Math.max(max, points[i]);
        }
        System.out.println(max);
    }
}
