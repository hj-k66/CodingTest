package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 26,564 kb | 147 ms
 */
public class Solution_4013_특이한자석{
	static int[][] magnet;
	static int[] isRotated;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int K = Integer.parseInt(br.readLine());
			// 자성정보
			magnet = new int[5][8];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			// 회전정보
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				isRotated = new int[5];
				int magNum = Integer.parseInt(st.nextToken()); // 회전시키려는 자석의 번호
				int dir = Integer.parseInt(st.nextToken()); // 회전방향

				isRotated[magNum] = dir;
				// 돌릴 자석 찾기
				findRotateMagnet(magNum);
				// 회전
				rotate();
			}

			// 점수계산
			int score = calculateScore();
			sb.append('#').append(test).append(' ').append(score).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void printMag() {
		for(int i = 1; i <= 4; i++) {
			System.out.print(isRotated[i] + " ");
		}
		System.out.println();
	}

	private static void print() {
		for (int i = 1; i <= 4; i++) {
			System.out.print(i + "번 자석 : ");
			for (int j = 0; j < 8; j++) {
				System.out.print(magnet[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int calculateScore() {
		int answer = 0;
		if (magnet[1][0] == 1) { // 1번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 S극이면
			answer += 1;
		}
		if (magnet[2][0] == 1) { // 2번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 S극이면
			answer += 2;
		}
		if (magnet[3][0] == 1) { // 3번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 S극이면
			answer += 4;
		}
		if (magnet[4][0] == 1) { // 4번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 S극이면
			answer += 8;
		}
		return answer;
	}

	private static void findRotateMagnet(int magNum) {
		
		// 현재 돌리려는 자석과 서로 붙어 있는 날의 자성이 다른지 확인 -> 다르면 반대 방향으로 1칸 회전
		if(magNum+1 <= 4) {
			if (magnet[magNum][2] != magnet[magNum + 1][6]) { // 극이 다르면
				if (isRotated[magNum+1] == 0) {
					isRotated[magNum + 1] = -1 * isRotated[magNum];
					findRotateMagnet(magNum + 1);

				}
					
			}
		}
		
		if (magNum - 1 >= 0) {
			if (magnet[magNum - 1][2] != magnet[magNum][6]) {
				if (isRotated[magNum-1] == 0) {
					isRotated[magNum - 1] = -1 * isRotated[magNum];
					findRotateMagnet(magNum - 1);

				}
			}
		}

	}

	static void rotate() {
		for (int i = 1; i <= 4; i++) {
			if (isRotated[i] == 0)
				continue;
			if(isRotated[i] == -1) {
				int temp = magnet[i][7];
				for (int j = 0; j < 7; j++) {
					magnet[i][(j + 8 + isRotated[i]) % 8] = magnet[i][j];
				}
				magnet[i][(7 + 8 + isRotated[i]) % 8] = temp;
			}
			
			else {	//시계방향
				int temp = magnet[i][0];
				for (int j = 7; j >= 1; j--) {
					magnet[i][(j + isRotated[i] + 8) % 8] = magnet[i][j];
				}
				magnet[i][1] = temp;
			}
			
		}
	}
}
