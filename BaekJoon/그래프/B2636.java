package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 	12824KB	|	116ms
public class B2636 {
	static int N;
	static int M;
	static int[][] temp;
	static int cheeseCnt;

	static int hour;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		cheeseCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeseCnt++;
			}
		}
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, M);
		}

		int answer = cheeseCnt;
		do {
			answer = cheeseCnt;
			BFS(map);	
			hour++;
			for (int i = 0; i < N; i++) {	
				System.arraycopy(temp[i], 0, map[i], 0, M);
			}

		} while (cheeseCnt > 0);

		System.out.println(hour);
		System.out.println(answer);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void BFS(int[][] map) {	//0,0부터 BFS 탐색 -> 바깥쪽 치즈만 탐색 가능
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, 0 });
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx[d];
				int ny = curr[1] + dy[d];
				if (!inRange(nx, ny)) continue;
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 0) {
						q.offer(new int[] { nx, ny });
					}
					if (map[nx][ny] == 1) {	// 치즈 녹이기
						temp[nx][ny] = 0;
						cheeseCnt--;
					}
				}

			}
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
