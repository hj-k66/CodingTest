package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 17070 파이프 옮기기 1
public class B17070 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//로직
		// dp[i][j][d] : d방향으로 i,j위치에 파이프 끝이 놓일 수 있는 경우의 수
		int[][][] dp = new int[N][N][3];	// 0: 가로, 1: 세로, 2: 대각선
		dp[0][1][0] = 1;	//초기에 놓여져 있는 것
		for(int i = 0; i < N; i++) {
			for(int j = 2; j < N; j++) {
				if(map[i][j] == 1) continue;
				
				//가로
				if(j-1 >= 0) {
					// 현재 가로 방향으로 놓으려고 할 때, 가능한 이전 모양 : 가로, 대각선
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				}
				
				//세로
				if(i-1 >= 0) {
					dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				}
				
				//대각선
				if(i-1 >= 0 && j-1 >= 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
					dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		
		//최종 출력
		System.out.println(dp[N-1][N-1][0] +dp[N-1][N-1][1]+dp[N-1][N-1][2] );
	}
}
