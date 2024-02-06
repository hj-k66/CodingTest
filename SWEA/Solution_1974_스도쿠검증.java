package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18,868 kb | 112 ms
public class Solution_1974_스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test = 1; test <= T; test++) {
            int[][] arr = new int[10][10];
            boolean[][] row = new boolean[10][10];
            boolean[][] col = new boolean[10][10];
            boolean isSudokuRowOrColumn = true;
            for (int i = 1; i <= 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 9; j++) {
                    int curr = Integer.parseInt(st.nextToken());
                    arr[i][j] = curr;
                    if (row[i][curr] || col[j][curr]) { //가로 or 세로에서 이미 체크한 숫자가 또 나온 경우 -> 숫자가 겹치게 나온 경우
                        isSudokuRowOrColumn = false;
                    }
                    row[i][curr] = true;
                    col[j][curr] = true;
                }
            }

            if (isSudokuSquare(arr) && isSudokuRowOrColumn) {    //3*3 스도쿠 확인
                System.out.println("#" + test + " " + 1);
                continue;
            }

            System.out.println("#" + test + " " + 0);   //스도쿠 없을 경우
        }

    }

    private static boolean isSudokuSquare(int[][] arr) {
        for (int i = 1; i <= 9; i += 3) { //3*3 스도쿠 확인
            for (int j = 1; j <= 9; j += 3) {
                boolean[] isVisited = new boolean[10];
                for (int h = i; h < i + 3; h++) {
                    for (int w = j; w < j + 3; w++) {
                        if (isVisited[arr[h][w]]) {
                            return false;
                        }
                        isVisited[arr[h][w]] = true;
                    }
                }
            }
        }
        return true;
    }
}
