package CodingTest.BaekJoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2630 색종이 만들기
 */
public class B2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,n);
        System.out.println(white);
        System.out.println(blue);


    }

    static void partition(int row, int col, int size){

        if(checkColor(row, col, size)){
            if(paper[row][col] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    static boolean checkColor(int row, int col, int size){
        int color = paper[row][col];

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col + size; j++){
                if(paper[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
