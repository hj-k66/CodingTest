package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Savepoint;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 87,556 kb	|	429 ms
public class Solution_2117_홈방범서비스 {
	static int N;
	static int M;
	static int[][] map;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//로직
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					BFS(i,j);
				}
			}
			
			sb.append('#').append(test).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void BFS(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {x,y});
		boolean[][] visited = new boolean[N][N];
		visited[x][y] = true;
		int benefit = 0;
		if(map[x][y] == 1) {
			benefit += M;
		}
		int k = 1;
		int cost = k*k + (k-1)*(k-1);
		if(benefit - cost >= 0) {
			answer = Math.max(answer, benefit / M);	//집의 갯수
		}
		
		k++;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {		//너비만큼 k증가
				int[] curr = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = curr[0] + dx[d];
					int ny = curr[1] + dy[d];
					
					if(!inRange(nx,ny)) continue;
					if(visited[nx][ny]) continue;
					queue.offer(new int[]{nx,ny});
					visited[nx][ny] = true;
					if(map[nx][ny] == 1) {
						benefit += M;
					}

				}
			}
			cost = k*k + (k-1)*(k-1);
			if(benefit - cost >= 0) {
				answer = Math.max(answer, benefit / M);	//집의 갯수
			}
			k++;
		}
		
	}
	
	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
