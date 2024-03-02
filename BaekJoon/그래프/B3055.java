package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//[BOJ] 3055 탈출
// 	11840KB	|	84ms

// BFS 너비별로 돌리기
// BFS 한 너비에서 물이랑 고슴도치 동시 이동
// 물 먼저 이동
// 1. 물 이동
// 	- 만약 *이 아니라면 map[x][y] = *
//  - q.offer(new Node(x,y,물)
// 2. 고슴도치 이동
// 	- 만약 빈칸이면 이동 가능
// - visited[x][y] = true;
// - map에는 표시 x
// q.offer(new Node(x,y,고슴도치))
public class Main_B_3055_탈출_김희정 {
	
	static int R;
	static int C;
	static char[][] map;
	static int Bx;	//비버의 x좌표
	static int By;
	static int hedgehogX; 	//초기 고슴도치의 x좌표
	static int hedgehogY;	//초기 고슴도치의 y좌표
	static List<int[]> waters;	//초기 물의 좌표들
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		waters = new ArrayList<int[]>();
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					hedgehogX = i;
					hedgehogY = j;
				}
				if(map[i][j] == 'D') {
					Bx = i;
					By = j;
				}
				if(map[i][j] == '*') {	//물이면
					waters.add(new int[] {i,j});
				}
			}
		}
		
		//로직
		BFS();
		
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];	//고슴도치 방문체크
		for(int[] w : waters) {	//초기 물
			queue.add(new int[] {w[0], w[1], '*'});
		}
		queue.add(new int[] {hedgehogX, hedgehogY, 'S'});	//초기 고슴도치
		visited[hedgehogX][hedgehogY] = true;
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int[] curr = queue.poll();
				
				if(curr[2] == 'S' && curr[0] == Bx && curr[1] == By) {
					System.out.println(time);
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = curr[0] + dx[d];
					int ny = curr[1] + dy[d];
					if(!inRange(nx, ny)) continue;
					if(curr[2] == '*') {	//물일 때,
						// 1. 물 이동
//					 	- 만약 s나 .이면 map[x][y] = *
					//  - q.offer(new Node(x,y,물)
						if(map[nx][ny] == 'S' || map[nx][ny] == '.') {
							map[nx][ny] = '*';
							queue.offer(new int[] {nx,ny,'*'});
						}
					}
					
					if(curr[2] == 'S') {	//고슴도치 일때,
						// 2. 고슴도치 이동
//					 	- 만약 빈칸이면 이동 가능
					// - visited[x][y] = true;
					// - map에는 표시 x
					// q.offer(new Node(x,y,고슴도치))
						if(visited[nx][ny]) continue;
						if(map[nx][ny] == '.' || map[nx][ny] == 'D') {
							visited[nx][ny] = true;
							queue.offer(new int[] {nx,ny,'S'});
						}
					}
				}
			}
			time++;
		}
		System.out.println("KAKTUS");
	}
	
	static boolean inRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}

