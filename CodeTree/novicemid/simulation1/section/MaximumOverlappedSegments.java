package CodingTest.CodeTree.novicemid.simulation1.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 구간 칠하기 / 최대로 겹치는 구간
 */
public class MaximumOverlappedSegments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] segments = new int[200];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            x1 += 100;
            x2 += 100;
            //겹치는 구간
            for(int j = x1; j < x2; j++){
                segments[j]++;
            }
        }
        //최대로 겹치는 구간
        int max = 0;
        for(int i = 0; i < 200; i++){
            max = Math.max(max, segments[i]);
        }
        System.out.println(max);
    }
}
