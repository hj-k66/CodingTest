package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2578 {

	static boolean[][] visited = new boolean[5][5];

	static boolean inRange(int x, int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5;
	}

	static boolean isBingoForRow(int row) {
		for (int c = 0; c < 5; c++) {
			if (!visited[row][c])
				return false;
		}
		return true;
	}

	static boolean isBingoForCol(int col) {
		for (int r = 0; r < 5; r++) {
			if (!visited[r][col])
				return false;
		}
		return true;
	}

	static boolean isBingoForCrossLeft(int row, int col) {
		if (row != col || row + col != 4)
			return false;
		for (int i = 0; i < 5; i++) {
			if (!visited[i][i])
				return false;
		}
		return true;
	}

	static boolean isBingoForCrossRight(int row, int col) {
		if (row + col != 4)
			return false;
		for (int i = 0; i < 5; i++) {
			if (!visited[i][4 - i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> grid = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> arr = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			grid.add(arr);
		}
		
		// 사회자 번호
		int numCnt = 0;
		int bingo = 0;
		A: for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int currNum = Integer.parseInt(st.nextToken());
				for (int row = 0; row < 5; row++) {
					int col = grid.get(row).indexOf(currNum);
					if (col == -1)
						continue;
					visited[row][col] = true;
					numCnt++;

					if (numCnt >= 5) {
						// 현재 row, col 기준 빙고 있는지 check
						// 가로
						if (isBingoForRow(row)) {
							bingo++;
						}
						// 세로
						if (isBingoForCol(col)) {
							bingo++;
						}
						// 대각선
						if (isBingoForCrossLeft(row, col)) {
							bingo++;
						}
						if (isBingoForCrossRight(row, col)) {
							bingo++;
						}
						if (bingo >= 3) {
							System.out.println(numCnt);
							break A;
						}
					}
				}

			}
		}

	}

}
