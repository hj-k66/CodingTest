package CodingTest.CodeTree.novicemid.simulation1.square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 사각형 칠하기 / 겹치지 않는 사각형의 넓이
 */
public class AreaOfNonOverlappingRectangle {
    static int[][] coord = new int[2001][2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Ax1 = Integer.parseInt(st.nextToken());
        int Ay1 = Integer.parseInt(st.nextToken());
        int Ax2 = Integer.parseInt(st.nextToken());
        int Ay2 = Integer.parseInt(st.nextToken());
        calcForArr(Ax1, Ax2, Ay1, Ay2, 1);
        st = new StringTokenizer(br.readLine());
        int Bx1 = Integer.parseInt(st.nextToken());
        int By1 = Integer.parseInt(st.nextToken());
        int Bx2 = Integer.parseInt(st.nextToken());
        int By2 = Integer.parseInt(st.nextToken());
        calcForArr(Bx1, Bx2, By1, By2, 1);
        st = new StringTokenizer(br.readLine());
        int Mx1 = Integer.parseInt(st.nextToken());
        int My1 = Integer.parseInt(st.nextToken());
        int Mx2 = Integer.parseInt(st.nextToken());
        int My2 = Integer.parseInt(st.nextToken());
        calcForArr(Mx1, Mx2, My1, My2, 2);

        //1의 갯수 세기
        int total = 0;
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(coord[i][j] == 1){
                    total++;
                }
            }
        }
        System.out.println(total);

    }
    static void calcForArr(int x1, int x2, int y1, int y2, int value){
        x1 += 1000;
        x2 += 1000;
        y1 += 1000;
        y2 += 1000;
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                coord[i][j] = value;
            }
        }
    }
}
