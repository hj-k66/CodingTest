package CodingTest.BaekJoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 1780 종이의 개수
내풀이 : 분할정복 -> 9개로 분할
 */
public class B1780 {
    static int minus;
    static int zero;
    static int one;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper  = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);


    }

    static void partition(int row, int col, int size){
        if(check(row, col, size)){
            if(paper[row][col] == -1){
                minus++;
            } else if (paper[row][col] == 0) {
                zero++;
            }else{
                one++;
            }
            return;
        }
        int newSize = size / 3;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2*newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col + newSize, newSize);
        partition(row+newSize, col + 2*newSize, newSize);
        partition(row+2*newSize, col, newSize);
        partition(row+2*newSize, col + newSize, newSize);
        partition(row+2*newSize, col + 2*newSize, newSize);

    }

    static boolean check(int row, int col, int size){
        int num = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++){
                if(paper[i][j]!=num){
                    return false;
                }
            }
        }
        return true;
    }

}
