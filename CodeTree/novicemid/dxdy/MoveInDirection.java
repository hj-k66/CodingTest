package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 방향에 맞춰 이동
 */
public class MoveInDirection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            if(direction.equals("W")){
                x += -1 * distance;
            }else if (direction.equals("S")){
                y += -1 * distance;
            } else if (direction.equals("N")) {
                y += distance;
            } else if (direction.equals("E")) {
                x += distance;
            }
        }
        System.out.println(x + " " + y);
    }
    
    void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            int moveDir = 0;
            if(direction.equals("E"))
                moveDir = 0;
            else if (direction.equals("W")) {
                moveDir = 1;
            } else if (direction.equals("S")) {
                moveDir = 2;
            } else if (direction.equals("N")) {
                moveDir = 3;
            }
            
            x += dx[moveDir] * distance;
            y += dy[moveDir] * distance;
        }
        System.out.print(x + " " + y);

    }
}
