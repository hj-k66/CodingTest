package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21,500 kb | 189 ms
public class Solution_4012_요리사 {

	static int[] outputA;
	static boolean[] isA;
	static int n;
	static int[][] arr;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 로직
			outputA = new int[n / 2];
			isA = new boolean[n];
			isA[0] = true; // 0 포함
			min = Integer.MAX_VALUE;
			comb(1, 1);		// a그룹의 포함되는 숫자들의 경우의 수 구하기
			System.out.println("#" +  test + " " + min);
		}
	}

	static void comb(int idx, int start) {
		if (idx == n / 2) {
			

			// 시너지 계산
			// 뽑히지 않은 값(false)은 b그룹

			int sumA = calculateSynergy(isA, true);
			int sumB = calculateSynergy(isA, false);
			min = Math.min(min, Math.abs(sumA - sumB));
			return;

		}

		for (int i = start; i < n; i++) {
			isA[i] = true;
			comb(idx + 1, i + 1);
			isA[i] = false;
		}
	}

	static int calculateSynergy(boolean[] isA, boolean flag) {	// n/2C2
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if(isA[i] == flag && isA[j] == flag) {
					sum += arr[i][j] + arr[j][i];
				}
				
			}
		}
		return sum;
	}
}
