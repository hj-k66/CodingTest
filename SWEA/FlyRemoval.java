package CodingTest.SWEA;

import java.util.Scanner;

public class FlyRemoval {

	static int n;

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, -1, 1 };
		int[] ddx = new int[] { -1, -1, 1, 1 };
		int[] ddy = new int[] { -1, 1, -1, 1 };
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			int M = sc.nextInt();

			int[][] grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					grid[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 십자
					int fly = grid[i][j];
					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int newX = i + dx[d] * m;
							int newY = j + dy[d] * m;
							if (inRange(newX, newY)) {
								fly += grid[newX][newY];
							}
						}
					}
					max = Math.max(max, fly);
					// x자
					fly = grid[i][j];
					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int newX = i + ddx[d] * m;
							int newY = j + ddy[d] * m;
							if (inRange(newX, newY)) {
								fly += grid[newX][newY];
							}
						}
					}
					max = Math.max(max, fly);

				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

}
