package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[SWEA] 1873 상호의 배틀필드
21,608 kb | 131 ms
 */
public class SWEA1873_상호의배틀필드 {
    static int H;   //맵 높이
    static int W;   //맵 너비
    static char[] tankShape = {'^', 'v','<','>'};
    static int[] dx = {-1, 1, 0,0}; //상, 하, 좌, 우
    static int[] dy = {0,0,-1,1};
    static int tankX;
    static int tankY;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            tankX = 0;
            tankY = 0;
            for(int i = 0; i < H; i++){
                String s = br.readLine();
                for(int j = 0; j < W; j++){
                    map[i][j] = s.charAt(j);
                    for(int k = 0; k < 4; k++){
                        if(tankShape[k] == map[i][j]){ // 전차의 초기 위치 세팅
                            tankX = i;
                            tankY = j;
                        }
                    }
                }
            }
            //사용자입력
            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();
            for(int i = 0; i < N; i++){
                char c = command.charAt(i);
                if(c == 'S') shoot();
                else{
                    move(c);
                }
            }

            sb.append('#').append(tc).append(' ');
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }

        }

        System.out.println(sb);
    }

    static void move(char command){
        if(command == 'U'){
            moveByDirection(0);
        }
        if(command == 'D'){
            moveByDirection(1);

        }
        if(command == 'L'){
            moveByDirection(2);

        }
        if(command == 'R'){
            moveByDirection(3);

        }
    }

    static void moveByDirection(int d){
        map[tankX][tankY] = tankShape[d];
        int nx = tankX + dx[d];
        int ny = tankY + dy[d];
        if(!inRange(nx,ny)) return;
        if(map[nx][ny] == '.'){
            map[nx][ny] = tankShape[d];
            map[tankX][tankY] = '.';
            tankX = nx;
            tankY = ny;

        }
    }

    static void shoot(){
        int direction = getTankDirection(map[tankX][tankY]);
        int x = tankX;
        int y = tankY;
        while(true){
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            //강철로 만들어진 벽에 충돌하면
            // 포탄이 소멸한다.
            if(!inRange(nx,ny) || map[nx][ny] == '#') return;
            if(map[nx][ny] == '*'){
                //포탄이 벽돌로 만들어진 벽에 충돌하면
                // 평지로 바뀌고 소멸한다.
                map[nx][ny] = '.';
                return;
            }

            x = nx;
            y = ny;
        }
    }

    static boolean inRange(int x, int y){
        return 0 <= x && x < H && 0 <= y && y < W;
    }

    static int getTankDirection(char tank){
        if(tank == '^') return 0;
        if(tank == 'v') return 1;
        if(tank == '<') return 2;
        if(tank == '>') return 3;
        return 0;
    }
}
