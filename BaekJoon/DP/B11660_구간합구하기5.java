package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 11660 구간 합 구하기 5
130716KB |	976ms
[문제해석]
N = 1024, M = 10만
N*N 2차원 배열
[문제 풀이]
가로행을 기준으로 누적합을 구하고 2차원 배열에 저장한다.
ex) sumArr[3][4] = 3행 0열 ~ 3행 4열까지 누적합
(2,2) ~ (3,4)까지의 합은 2행의 누적합(2,2) ~ (2,4) + 3행의 누적합 (3,2) ~ (3,4) 계산
[시간복잡도]
최대 행의 갯수 * 최대 M = 1024*10만 = 1억2백4만 => 1초로 가능

[다른 풀이 - DP]
131600KB | 680ms
문제에서 구해야하는 구간 합은 주어진 열(y1,y2)을 기준으로 행이 바뀌는 경우이므로, 누적합 또한 이 기준을 따라 구한다.
ex) (2,2)까지의 누적합은 (1,1) ~ (1,4) ~ (2,2) 가 아니라 (1,1) + (1,2) + (2,1) + (2,2)
이전 누적값을 활용해 구하고, 중복되는 값은 제거
 */
public class B11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                sumArr[i][j] = arr[i][j] + sumArr[i][j-1];
            }
        }
//        System.out.println("누적합 배열");
//        for(int i = 1; i <= N; i++){
//            System.out.println(Arrays.toString(sumArr[i]));
//        }

        StringBuilder sb = new StringBuilder();
        int x1, x2, y1, y2;
        int sum;
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            sum = 0;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int x = x1; x <= x2; x++){
                sum += sumArr[x][y2] - sumArr[x][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static void otherSolutionDP() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
//        System.out.println("누적합 배열");
//        for(int i = 1; i <= N; i++){
//            System.out.println(Arrays.toString(sumArr[i]));
//        }

        StringBuilder sb = new StringBuilder();
        int x1, x2, y1, y2;
        int sum;
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sum = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
