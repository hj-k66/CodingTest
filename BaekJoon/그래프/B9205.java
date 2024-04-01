package CodingTest.BaekJoon.그래프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 	13060KB	|	100ms
// 0. 각 지점 별 좌표를 배열에 저장, 지점에 숫자 부여
// 1. 각 지점 별 거리를 모두 구하기 -> 1000이하이면 연결되었다고 표시 -> 그래프화
// 2. 1에서 만든 그래프를 BFS 돌리기 -> 페스티발이면 happy 출력
public class B9205 {
	
	static class Coord{
		int x;
		int y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int calculateDistance(Coord c) {
			return Math.abs(this.x - c.x) + Math.abs(this.y - c.y);
		}
	}
	
	static int[][] adj;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test < t; test++) {
			n = Integer.parseInt(br.readLine()); 
			Coord[] shop = new Coord[n+2];
			adj = new int[n+2][n+2];
			//입력
			for(int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				shop[i] = new Coord(x,y);
			}
			
			//거리 구하기 -> 그래프화
			for(int i = 0; i < n+2; i++) {
				for(int j = i+1; j < n+2; j++) {
					int distance = shop[i].calculateDistance(shop[j]);
					if(distance <= 1000) {
						adj[i][j] = 1;
						adj[j][i] = 1;
					}
				}
			}
			//BFS 수행
			sb.append(bfs()).append('\n');
		}
		System.out.println(sb);
	}
	
	static String bfs() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[n+2];
		
		q.add(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == n+1) {
				return "happy";
			}
			for(int i = 0; i < n+2; i++) {
				if(adj[curr][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		return "sad";
	}
}
