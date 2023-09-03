package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 작은 구슬의 이동
 */
public class SmallMarbleMovement {
    static int n;
    static int getDirection(String d){
        if(d.equals("U")){
            return 0;
        } else if (d.equals("L")) {
            return 1;
        } else if (d.equals("R")) {
            return 2;
        } else if (d.equals("D")) {
            return 3;
        }
        return -1;
    }
    static boolean inRange(int x, int y){
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String d = st.nextToken();
        int[] dx = new int[]{-1, 0, 0, 1};//상좌우하
        int[] dy = new int[]{0, -1, 1, 0};
        int curDir = getDirection(d);

        while(t-- > 0){
            int nx = r + dx[curDir]; int ny = c + dy[curDir];
            if(!inRange(nx, ny)){
                curDir = 3 - curDir;
                continue;
            }
            r = nx;
            c = ny;
        }
        System.out.println(r + " " + c);
    }
}
