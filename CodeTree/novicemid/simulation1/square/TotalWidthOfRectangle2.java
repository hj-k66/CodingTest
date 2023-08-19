package CodingTest.CodeTree.novicemid.simulation1.square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 사각형 칠하기 / 사각형의 총 넓이 2
 */
public class TotalWidthOfRectangle2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] coord = new int[201][201];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            x1 += 100; y1 += 100; x2 += 100; y2 += 100;
            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    coord[x][y] = 1;
                }
            }
        }

        //넓이 계산
        int total = 0;
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                total += coord[i][j];
            }
        }

        System.out.println(total);
    }
}
