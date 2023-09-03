package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[CodeTree] dx dy technique / 거울에 레이저 쏘기 2
 */
public class ShootALaserInTheMirror2 {
    static int n;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());
        int direction = 0;
        if (k != 1) {
            direction = (k-1) / n; //위, 오, 아래, 왼
        }
        int location = (k - 1) % n; // 좌표

        int x = 0;
        int y = 0;
        if (direction == 0) { // 위
            x = 0;
            y = location;
        } else if (direction == 1) { //오
            x = location;
            y = n - 1;
        } else if (direction == 2) { // 아래
            x = n - 1;
            y = n - 1 - location;
        } else if (direction == 3) { // 왼
            x = n - 1 - location;
            y = 0;
        }
        int[] dx = new int[]{-1, 0, 1, 0}; //위, 오, 아래, 왼
        int[] dy = new int[]{0, 1, 0, -1};

        while (true) {
            int dir;
            if (grid[x][y] == '/') {
                dir = 3 - direction;
            } else {
                if (direction < 2) {
                    dir = 1 - direction;
                } else {
                    dir = 5 - direction;
                }
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            result++;

            if (!inRange(nx, ny)) {
                break;
            } else {
                x = nx;
                y = ny;
                direction = (dir + 2) % 4;
            }
        }

        System.out.println(result);


    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }


    static int x,y,moveDir;
    static char[][] arr;
    public static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());

        initialize(k); //시작 위치와 방향 구하기
        int moveNum = simulate();
    }

    public static void initialize(int num) {
        if(num <= n) {
            x = 0; y = num - 1; moveDir = 0;
        }
        else if(num <= 2 * n) {
            x = num - n - 1; y = n - 1; moveDir = 1;
        }
        else if(num <= 3 * n) {
            x = n - 1; y = n - (num - 2 * n); moveDir = 2;
        }
        else {
            x = n - (num - 3 * n); y = 0; moveDir = 3;
        }
    }
    public static int simulate() {
        int moveNum = 0;
        while(inRange(x, y)) {
            // 0 <-> 1 / 2 <-> 3
            if(arr[x][y] == '/')
                move(moveDir ^ 1);
                // 0 <-> 3 / 1 <-> 2
            else
                move(3 - moveDir);

            moveNum += 1;
        }

        return moveNum;
    }
    // (x, y)에서 시작하여 nextDir 방향으로
    // 이동한 이후의 위치를 구합니다.
    public static void move(int nextDir) {
        int[] dx = new int[]{1,  0, -1, 0};
        int[] dy = new int[]{0, -1,  0, 1};

        x += dx[nextDir];
        y += dy[nextDir];
        moveDir = nextDir;
    }
}
