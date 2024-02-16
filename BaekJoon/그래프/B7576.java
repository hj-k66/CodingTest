import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 101492KB	|	568ms
public class Main {
	static int N;
	static int M;
	static int[][] map;
	static Queue<Tomato> ripeTomatoes;	//익은 토마토 정보 저장
	static int[] dx = {0,0,-1,1};	
	static int[] dy = {-1,1,0,0};
	static int answer;
	
	static class Tomato{
		int x;
		int y;
		int day;	// 익힌 날 기록
		
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ripeTomatoes = new ArrayDeque<>();
		int rawTomatoCnt = 0; //안익은 토마토 갯수
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					ripeTomatoes.add(new Tomato(i, j, 0));	// 1. 익은 토마토 위치 저장
				}
				if(map[i][j] == 0) {
					rawTomatoCnt++;
				}
			}
		}
		
		if(rawTomatoCnt == 0) {	//안익은 토마토가 없으면 저장될 때부터 모든 토마토가 익어있는 상태
			System.out.println(0);
			return;
		}
		
		
		// 2. 초기 1인 토마토 위치에서 BFS 진행
		while(!ripeTomatoes.isEmpty()) {
			Tomato curr = ripeTomatoes.poll();
			answer = curr.day;
			
			for(int d = 0; d < 4; d++) {	//상하좌우 탐색
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				if(!inRange(nx, ny)) continue;
				if(map[nx][ny] == 0) {
					ripeTomatoes.offer(new Tomato(nx, ny, curr.day + 1));
					map[nx][ny] = 1;		//토마토 익히기
					rawTomatoCnt--;	//익지 않은 토마토 갯수 빼기
				}
			}
			if(rawTomatoCnt == 0) {
				System.out.println(answer+1);	//익지 않은 토마토가 없으면, 종료
				return;
			}
		}
		
		// 익지 않은 토마토가 남아 있는 경우
		System.out.println(-1);

		
	}
	
	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M; 
	}

}
