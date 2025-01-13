package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[SWEA] 1974 스도쿠 검증
18,608 kb | 104 ms
[문제 풀이]
- 가로행, 세로행, 작은 사각형을 검사하는 boolean 배열을 각각 만들어 중복 체크하기
 */
public class SWEA1974_스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] sudoku;
        A : for(int tc = 1; tc <= T; tc++){
            sb.append('#').append(tc).append(' ');

            sudoku = new int[9][9];
            boolean[][] widthArr = new boolean[9][10];  //가로
            boolean[][] heightArr = new boolean[9][10]; //세로
            boolean[][] squareArr = new boolean[9][10];

            for(int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //로직
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    //가로행 검사
                    if(widthArr[i][sudoku[i][j]]){
                        sb.append(0).append('\n');   //겹치는 숫자가 있는 경우
                        continue A;
                    }
                    //세로행 검사
                    if(heightArr[j][sudoku[i][j]]){
                        sb.append(0).append('\n');   //겹치는 숫자가 있는 경우
                        continue A;
                    }
                    widthArr[i][sudoku[i][j]] = true;
                    heightArr[j][sudoku[i][j]] = true;
                }
            }

            //작은 사각형 검사
            for(int s = 0; s < 9; s+=3){
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        int num = sudoku[i+s][j+s];
                        if(squareArr[s][num]){
                            sb.append(0).append('\n');
                            continue A;
                        }
                        squareArr[s][num] = true;
                    }
                }
            }

            sb.append(1).append('\n');

        }
        System.out.println(sb);
    }

    /*
    [1~9까지의 합 : 45로 판단]
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] sudoku;
        A : for(int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //로직
            //가로행, 세로행 검사
            for(int i = 0; i < 9; i++){
                int rowSum = 0;
                int colSum = 0;
                for(int j = 0; j < 9; j++){
                    rowSum += sudoku[i][j];
                    colSum += sudoku[j][i];
                }
                if(rowSum != 45 || colSum != 45){
                    sb.append(0).append('\n');
                    continue A;
                }
            }

            for(int s = 0; s < 9; s+= 3){
                int squareSum = 0;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        squareSum += sudoku[i][j];
                    }
                }

                if(squareSum != 45){
                    sb.append(0).append('\n');
                    continue A;
                }
            }
            sb.append(1).append('\n');
        }
        System.out.println(sb);
    }
}
