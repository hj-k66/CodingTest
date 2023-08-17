package CodingTest.CodeTree.novicemid.simulation1.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 구간 칠하기 / 신기한 타일 뒤집기
 */
public class StrangeFlippingTiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX_TILE = 100000;
        int[] tiles = new int[2*MAX_TILE + 1];
        int n = Integer.parseInt(br.readLine());

        int cur = MAX_TILE;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            if(command.equals("L")){
                while(x-- > 0 ){
                    tiles[cur] = 1;
                    if(x > 0) cur--;
                }
            } else if (command.equals("R")) {
                while(x-- > 0){
                    tiles[cur] = 2;
                    if(x > 0) cur++;
                }
            }
        }

        //
        int white = 0;
        int black = 0;
        for (int tile : tiles) {
            if (tile == 1) {
                white++;
            } else if (tile == 2) {
                black++;
            }
        }

        System.out.println(white + " " + black);
    }
}
