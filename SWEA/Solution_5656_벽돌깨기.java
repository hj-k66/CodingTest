

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

//91,780 kb | 939 ms
public class Solution_5656_벽돌깨기 {
	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int[] marble;
	static int brickCnt;
	static int tempBrickCnt;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min;
	static int[][] temp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			brickCnt = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						brickCnt++;
				}
			}
			// 로직
			// 1. N개의 구슬 쏠 위치 뽑기 -> 중복 순열
			marble = new int[N];
			perm(0);
			sb.append('#').append(test).append(' ').append(min).append('\n');
		}
		System.out.println(sb);
	}

	static void perm(int cnt) {
		if (cnt == N) { // 구슬 위치 뽑기 완료
			// 2. 구슬 던지기 -> 행을 증가시키면서 처음 만나는 벽돌 부수기
			tempBrickCnt = brickCnt;
			// 벽돌 복사
			temp = new int[H][W];
			copyArray();

			A: for (int i = 0; i < N; i++) { // n개의 구슬 던지기
				int col = marble[i];
				for (int r = 0; r < H; r++) {
					if (temp[r][col] == 0)
						continue;
					// 벽돌 부수기
					removeBrick(r, col);
					
					// 빈 공간 이동
					dropBrick();
					continue A;
				}
			}

			// 가장 적은 벽돌 갯수로 갱신
			min = Math.min(min, tempBrickCnt);
			return;
		}

		for (int i = 0; i < W; i++) {
			marble[cnt] = i;
			perm(cnt + 1);
		}
	}

	static void copyArray() {
		for (int i = 0; i < H; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, W);
		}
	}

	static void dropBrick() {
		// 맨 아래부터 탐색
		// 해당 위치에 벽돌이 있고 바로 윗 칸이 빈 칸이라면
		// 빈칸 위에 있는 모든 벽돌을 아래로 내리기

		for (int r = H - 1; r > 0; r--) {
			for (int c = 0; c < W; c++) {
				if (temp[r][c] == 0) {
					int x = r - 1;
					while (x >= 0) {
						if (temp[x][c] != 0) { // 벽돌이면
							temp[r][c] = temp[x][c];
							temp[x][c] = 0;
							break;
						}
						x--;
					}
				}
			}
		}
	}

	static void removeBrick(int r, int c) {
		int range = temp[r][c] - 1;
		temp[r][c] = 0;
		tempBrickCnt--;

		// 벽돌에 적힌 숫자 -1 만큼 상하좌우 벽돌 제거
		for (int d = 0; d < 4; d++) {
			for (int l = 1; l <= range; l++) {
				int nx = r + dx[d] * l;
				int ny = c + dy[d] * l;

				if (!inRange(nx, ny))
					continue;
				if (temp[nx][ny] == 0)
					continue;

				removeBrick(nx, ny);
			}
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}

}
