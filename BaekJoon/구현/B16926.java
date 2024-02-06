package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 	31144KB | 696ms
public class B16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int squareCnt = Math.min(n,m) / 2;
        for(int cnt = 0; cnt < squareCnt; cnt++){   //사각형
            int rowBound = n - 1 - cnt;
            int colBound = m - 1 - cnt;
            int[] temp = new int[4];
            for(int r = 0; r < R; r++){
                //왼쪽
                temp[0] = arr[rowBound][cnt];
                for(int i = rowBound; i >= cnt+1; i--){
                    arr[i][cnt] = arr[i-1][cnt];
                }

                //아래
                temp[1] = arr[rowBound][colBound];
                for(int i = colBound-1; i >= cnt+1; i--){
                    arr[rowBound][i+1] = arr[rowBound][i];
                }
                arr[rowBound][cnt+1] = temp[0];


                //오른쪽
                temp[2] = arr[cnt][colBound];
                for(int i = cnt+1; i < rowBound; i++){
                    arr[i-1][colBound] = arr[i][colBound];
                }
                arr[rowBound - 1][colBound] = temp[1];

                //위
                for(int i = cnt +1; i < colBound;i++){
                    arr[cnt][i-1] = arr[cnt][i];
                }
                arr[cnt][colBound-1] = temp[2];
            }

        }
        //출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
