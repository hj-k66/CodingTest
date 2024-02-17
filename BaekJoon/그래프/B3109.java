import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int R;
	static int C;
	static int cnt;
	static int[] dx = { -1, 0, 1 }; // 우상, 우, 우하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		//로직
		for(int i = 0; i < R; i++) {
			if(setPipe(i, 0)) cnt++;
		}
		
		System.out.println(cnt);
	}

	static boolean setPipe(int r, int c) {
		if (c == C - 1) {	//끝에 도달
			return true;
		}
		
		
		for(int d = 0; d < 3; d++) {
			int nr = r + dx[d];
			int nc = c + 1;
			
			if(nr < 0 || nr >= R || map[nr][nc] == 'x') continue;
			map[nr][nc] = 'x';	//파이프 설치
			if(setPipe(nr, nc)) {
				return true;
			}
		}
		return false;

	}
	
}
