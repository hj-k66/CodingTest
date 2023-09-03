package CodingTest.CodeTree.novicemid.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] dx dy technique / 되돌아오기 1
 */
public class ComeBack {
    static int getDirNum(String direction){
        if(direction.equals("N")){
            return 0;
        }else if(direction.equals("S")){
            return 1;
        }else if(direction.equals("E")){
            return 2;
        } else if (direction.equals("W")) {
            return 3;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;
        int time = 0;
        int[] dx = new int[]{0, 0, 1, -1};//북남동서
        int[] dy = new int[]{1, -1, 0, 0};
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            int dirNum = getDirNum(direction);

            for(int j = 0; j < distance; j++){
                x += dx[dirNum];
                y += dy[dirNum];
                time += 1;
                if(x == 0 && y == 0){
                    System.out.println(time);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
