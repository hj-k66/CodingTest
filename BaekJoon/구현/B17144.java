package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 집 : RxC
- 공기청정기가 설치 x => 미세먼지 Ar,c


공기청정기
 - 1번 열에 설치
 - 크기 2행 차지
1초동안 일어나는 일
1. 미세먼지 확산
- 미세먼지 있는 모든 칸에서 동시 발생
- 인접한 4방으로 확산
- 인접 방향에 공기청정기 있거나, 칸 없으면 확산 x
- 확산되는 양 = A/5 => 소수점 버림
- r,c에 남은 미세먼지 양 : A - A/5*확산된 방향 갯수


2. 공기청정기 작동
- 위쪽 공기청정기 바람은 반시계로 순환
- 아래쪽 공기청정기 바람은 시계로 순환
- 바람 불면 미세먼지 바람 방향대로 모두 한 칸씩 이동 => 누적x
- 공기청정기로 들어간 미세먼지는 모두 정화

목표 : T초가 지난 후 남아있는 미세먼지 양 구하기

[해결 프로세스]
미세먼지 확산
원본 배열 map, 카피 배열 temp
-> 확산된 결과 카피 배열에 기록
1. map 배열 돌면서 미세먼지 발견
2. 해당 미세먼지 기준 4방 탐색	
	탐색 안되는 조건
	1. 공기청정기 있거나(map(nr,nc)==-1)
	2. 범위 벗어나거나
3. 탐색 가능한 곳에 map[r,c]/5 추가 -> 카피 배열에 기록
	- 중점의 미세먼지 감소
		temp[r,c] -= map[r,c]/5;
	- 탐색 횟수 count
4. map배열 다 돌았으면 temp를 map으로 

24760KB	|	308ms
 */
public class B17144 {
	static class AirCleaner {
		int upRow;
		int upCol;
		int downRow;
		int downCol;

		public AirCleaner(int r, int c) {
			this.downRow = r;
			this.downCol = c;
			this.upRow = downRow - 1;
			this.upCol = c;
		}
	}

	static int R;
	static int C;
	static int[][] map;
	static AirCleaner airCleaner;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) { // 공기청정기
					airCleaner = new AirCleaner(i, j);
					map[i][j] = 0;
				}
			}
		}

		// 로직
		while (T-- > 0) {
			// 미세먼지 확산
			spread();
			
			// 공기청정기 작동
			cleanUpAir();
			cleanDownAir();
		}

		// 남아있는 미세먼지 양 구하기
		int cnt = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(isAirCleaner(i, j))continue;
				cnt += map[i][j];
			}
		}
		
		System.out.println(cnt);
	}
	
	static void cleanUpAir() {
		//왼쪽
		for(int r = airCleaner.upRow-1; r > 0; r--) {
			map[r][0] = map[r-1][0];
		}
		//위쪽
		for(int c = 0; c < C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		//오른쪽
		for(int r = 0; r < airCleaner.upRow; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		//아래
		for(int c = C-1; c > 1; c--) {
			map[airCleaner.upRow][c] = map[airCleaner.upRow][c-1];
		}
		map[airCleaner.upRow][1] = 0;
	}
	
	static void cleanDownAir() {
		//왼쪽
		for(int r = airCleaner.downRow + 1; r < R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		//아래
		for(int c = 0; c < C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		
		//오른쪽
		for(int r = R-1; r > airCleaner.downRow; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		//위쪽
		for(int c = C-1; c > 1; c--) {
			map[airCleaner.downRow][c] = map[airCleaner.downRow][c-1];
		}
		
		map[airCleaner.downRow][1] = 0;
	}

	static void spread() {
		// 1. copy 배열 생성
		int[][] temp = arrayCopy();

		// 2. map 완탐
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue; // 공기청정기면 pass
				// 3. 4방 탐색
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(!inRange(nr, nc) || isAirCleaner(nr, nc)) continue;
					// 4. 탐색 가능한 곳에 map[r,c]/5 추가 -> copy배열에 기록
					temp[nr][nc] += map[i][j]/5;
					// 중점의 미세먼지 감소
					temp[i][j] -= map[i][j]/5;
				}
			}
		}
		
		//3. temp를 map으로
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}

	}
	static boolean isAirCleaner(int r, int c) {
		if(c == 0 && (r == airCleaner.upRow || r == airCleaner.downRow)) return true;
		return false;
	}

	static int[][] arrayCopy() {
		int[][] temp = new int[R][C];
		for (int i = 0; i < R; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, C);
		}
		return temp;
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C; 
	}
}
