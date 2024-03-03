package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 	48364KB	|	412ms
// [BOJ] 1600 말이 되고픈 원숭이
public class B1600 {
	static class Monkey {
		int x;
		int y;
		int horse;

		public Monkey(int x, int y, int horse) {
			super();
			this.x = x;
			this.y = y;
			this.horse = horse;
		}

		@Override
		public String toString() {
			return "Monkey [x=" + x + ", y=" + y + ", horse=" + horse + "]";
		}
		

	}

	static int[] dx = { -1, 1, 0, 0,  -2, -1, 1, 2, 2, 1, -1, -2  };
	static int[] dy = { 0, 0, -1, 1,  1, 2, 2, 1, -1, -2, -2, -1};

	static int W;
	static int H;
	static int K;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		K = Integer.parseInt(br.readLine());
		stringTokenizer = new StringTokenizer(br.readLine());
		W = Integer.parseInt(stringTokenizer.nextToken());
		H = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		// 로직
		BFS();
		
	}

	static void BFS() {
		Queue<Monkey> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[H][W][K + 1];
		
		int cnt = 0;
		queue.offer(new Monkey(0, 0, 0));
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Monkey curr = queue.poll();
				
				if (curr.x == H - 1 && curr.y == W - 1) {
					System.out.println(cnt);
					return;
				}
				
				for (int d = 0; d < 12; d++) {
					int nx = curr.x + dx[d];
					int ny = curr.y + dy[d];
					
					if (!inRange(nx, ny))
						continue;
					if(map[nx][ny] == 1) continue;
					if (d >= 4) { // 나이트 - 말로 이동
						if (curr.horse == K)
							break; // 더이상 말로 이동 불가
						if (visited[nx][ny][curr.horse + 1])
							continue;
						visited[nx][ny][curr.horse + 1] = true;
						queue.offer(new Monkey(nx, ny, curr.horse + 1));
					} else {
						if (visited[nx][ny][curr.horse])
							continue;
						visited[nx][ny][curr.horse] = true;
						queue.offer(new Monkey(nx, ny, curr.horse));
					}
				}
			}
			cnt++;
			
		}
		System.out.println(-1);
		
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}
