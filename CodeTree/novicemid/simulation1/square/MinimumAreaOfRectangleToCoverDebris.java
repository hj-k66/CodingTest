package CodingTest.CodeTree.novicemid.simulation1.square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 사각형 칠하기 / 잔해물을 덮기 위한 사각형의 최소 넓이
 */
public class MinimumAreaOfRectangleToCoverDebris {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] coord = new int[2001][2001];
        int Ax1 = Integer.parseInt(st.nextToken()) + 1000;
        int Ay1 = Integer.parseInt(st.nextToken())+ 1000;
        int Ax2 = Integer.parseInt(st.nextToken())+ 1000;
        int Ay2 = Integer.parseInt(st.nextToken())+ 1000;
        for(int i = Ax1; i < Ax2; i++){
            for(int j = Ay1; j < Ay2; j++){
                coord[i][j] = 1;
            }
        }
        st = new StringTokenizer(br.readLine());
        int Bx1 = Integer.parseInt(st.nextToken())+ 1000;
        int By1 = Integer.parseInt(st.nextToken())+ 1000;
        int Bx2 = Integer.parseInt(st.nextToken())+ 1000;
        int By2 = Integer.parseInt(st.nextToken())+ 1000;
        for(int i = Bx1; i < Bx2; i++){
            for(int j = By1; j < By2; j++){
                coord[i][j] = 2;
            }
        }
        int xmin = 2001; int xmax = 0;
        int ymin = 2001; int ymax = 0;
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(coord[i][j] == 1){
                    xmin = Math.min(i, xmin);
                    xmax = Math.max(i, xmax);
                    ymin = Math.min(j, ymin);
                    ymax = Math.max(j, ymax);
                }
            }
        }
        int area = 0;
        for(int i = xmin; i <= xmax; i++){
            for(int j = ymin; j <= ymax; j++){
                area++;
            }
        }
        System.out.println(area);


    }
}
