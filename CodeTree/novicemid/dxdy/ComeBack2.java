package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[CodeTree] dx dy technique / 되돌아오기 2
 */
public class ComeBack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String commands  = br.readLine();
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int curDir = 0;
        int time = 0;
        int ans = -1;
        for(int i = 0; i < commands.length(); i++){
            char curCommand = commands.charAt(i);
            if(curCommand == 'L'){
                curDir = (curDir - 1 + 4) % 4;
            } else if (curCommand == 'R') {
                curDir = (curDir + 1) % 4;
            }else{
                x += dx[curDir];
                y += dy[curDir];
            }
            time++;
            if(x == 0 && y == 0){
                ans = time;
                break;
            }
        }
        System.out.println(ans);
    }
}
