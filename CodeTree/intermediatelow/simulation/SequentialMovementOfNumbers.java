package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 여러 객체를 이동 / 숫자의 순차적 이동
 */
public class SequentialMovementOfNumbers {
    static int n;
    static int[][] arr;

    static void swap(int centerX, int centerY, int maxX, int maxY){
        int temp = arr[centerX][centerY];
        arr[centerX][centerY] = arr[maxX][maxY];
        arr[maxX][maxY] = temp;
    }

    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(m-- > 0){
            //targetNum = 1 ~ n*n까지 숫자 이동
            for(int targetNum = 1; targetNum <= n*n; targetNum++){
                //1. targetNum이 어느 좌표에 있는지 찾기
                int centerX = 0;
                int centerY = 0;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(arr[i][j] == targetNum){
                            centerX = i;
                            centerY = j;
                            break;
                        }
                    }
                }
                //2. 해당 좌표에서 8방향 탐색 -> 가장 큰 수와 바꾸기
                int[] dx = new int[]{-1,-1,-1, 0, 0, 1, 1, 1};
                int[] dy = new int[]{-1, 0, 1, -1, 1,-1, 0, 1};
                int max = 0;
                int maxX = 0;
                int maxY = 0;
                for(int i = 0; i < 8; i++){
                    int nx = centerX + dx[i];
                    int ny = centerY + dy[i];
                    if(inRange(nx, ny) && max < arr[nx][ny]){
                        maxX = nx;
                        maxY = ny;
                        max = arr[nx][ny];
                    }
                }
                //가장 큰수와 가운데 값 바꾸기
                swap(centerX, centerY, maxX, maxY);
            }
        }

        //출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
