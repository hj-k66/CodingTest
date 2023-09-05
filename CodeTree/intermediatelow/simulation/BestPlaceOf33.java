package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 완전탐색 / 최고의 33위치
 */
public class BestPlaceOf33 {
    static int[][] grid;

    static int getCoinCnt(int rowU, int rowD, int colL, int colR){
        int coinCnt = 0;
        for(int i = rowU; i < rowD; i++){
            for(int j = colL; j < colR; j++){
                coinCnt += grid[i][j];
            }
        }
        return coinCnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //3 * 3이 격자 범위 넘어가면 x
                if(i + 3 > n || j + 3 > n)
                    continue;
                //금의 갯수 계산
                int coinCnt = getCoinCnt(i, i + 3, j, j + 3);
                result = Math.max(coinCnt, result);
            }
        }

        System.out.println(result);

    }
}
