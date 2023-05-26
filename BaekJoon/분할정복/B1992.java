package CodingTest.BaekJoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 1992 쿼드트리 
내풀이 : 4개로 분할 >> 앞뒤로 괄호 붙이기
*/
public class B1992 {
    static int[][] video;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];
        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                video[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        partition(0,0,n);
        System.out.println(sb);


    }

    static void partition(int row, int col, int size){
        if(check(row, col, size)){
            sb.append(video[row][col]);
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        partition(row, col, newSize); //왼쪽 위
        partition(row, col + newSize, newSize); // 오른쪽 위
        partition(row + newSize, col, newSize); // 왼쪽 아래
        partition(row + newSize, col + newSize, newSize); // 오른쪽 아래
        sb.append(")");
    }

    static boolean check(int row, int col, int size){
        int dot = video[row][col];
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(video[i][j] != dot){
                    return false;
                }
            }
        }
        return true;
    }
}
