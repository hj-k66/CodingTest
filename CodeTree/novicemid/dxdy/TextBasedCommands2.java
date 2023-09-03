package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[CodeTree] dx dy technique / 문자에 따른 명령 2
시계방향, 반시계방향 움직임
 */
public class TextBasedCommands2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String commands = br.readLine();
        int[] dx = new int[]{0, 1, 0, -1}; //북, 동, 남, 서
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int moveDir = 0;
        for(int i = 0; i < commands.length(); i++){
            char c = commands.charAt(i);
            if(c == 'R'){
                moveDir = (moveDir + 1) % 4;
            } else if (c == 'L') {
                moveDir = (moveDir - 1 + 4) % 4;
            } else if (c == 'F') {
                x += dx[moveDir];
                y += dy[moveDir];
            }

        }
        System.out.println(x + " " + y);
    }
}

