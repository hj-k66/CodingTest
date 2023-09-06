package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 터지고 떨어지는 경우 / 십자 모양 폭발
 */
public class CrossShapeBomb {
    static int n;
    static int[][] arr;
    static int[][] temp;

    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        r--;
        c--;

        //로직
        int[] dx = new int[]{-1, 1, 0, 0}; //상하좌우
        int[] dy = new int[]{0, 0, -1, 1};
        int value = arr[r][c];
        temp = new int[n][n];
        otherSolution(r, c);
//        arr[r][c] = 0;
//
//        //폭발
//        for(int i = 0; i < 4; i++){
//            int nx = r;
//            int ny = c;
//            for(int j = 1; j < value; j++){
//                nx += dx[i];
//                ny += dy[i];
//                if(!inRange(nx, ny)){
//                    break;
//                }
//                arr[nx][ny] = 0;
//            }
//        }
//
//        //중력 이동
//        for(int col = 0; col < n; col++){
//            int tempRow = n - 1;
//            for(int row = n - 1; row >= 0; row--){
//                if(arr[row][col] != 0){
//                    temp[tempRow][col] = arr[row][col];
//                    tempRow--;
//                }
//            }
//        }

        //출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void otherSolution(int centerX, int centerY){
        int bombRange = arr[centerX][centerY];

        //폭탄
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(inBombRange(i,j,centerX, centerY, bombRange))
                    arr[i][j] = 0;
            }
        }
        //폭탄 터진 이후 결과 저장 -> 중력이동
        for(int col = 0; col < n; col++){
            int tempRow = n - 1;
            for(int row = n - 1; row >= 0; row--){
                if(arr[row][col] != 0){
                    temp[tempRow--][col] = arr[row][col];
                }
            }
        }
    }

    // 폭탄이 터진 위치와의 거리(맨하탄 거리)가 해당 칸에 적힌 숫자(bombRange)보다 작음
    static boolean inBombRange(int x, int y, int centerX, int centerY, int bombRange){
        return(x == centerX || y == centerY) &&
                Math.abs(x - centerX) + Math.abs(y - centerY) < bombRange;
    }
}
