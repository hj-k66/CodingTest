package CodingTest.CodeTree.novicemid.simulation1.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[CodeTree] 구간 칠하기 / 흰검 칠하기
 */
public class PaintingWhiteBlack {
    static class Tile{
        String finalColor; //black, white, gray
        int blackCnt;
        int whiteCnt;

        public Tile() {
            this.finalColor = "";
            this.blackCnt = 0;
            this.whiteCnt = 0;
        }

        public void plusBlackCnt(){
            this.blackCnt++;
        }
        public void plusWhiteCnt(){
            this.whiteCnt++;
        }


        public String getFinalColor() {
            return finalColor;
        }

        public int getBlackCnt() {
            return blackCnt;
        }

        public int getWhiteCnt() {
            return whiteCnt;
        }

        public void setFinalColor(String finalColor) {
            this.finalColor = finalColor;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tile[] tiles = new Tile[200001];
        for (int i=0; i<200001; i++) {
            tiles[i] = new Tile();
        }
        int start = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int x1; int x2;
            if(command.equals("L")){
                x1 = start - x+1;
                x2 = start;
                start = x1;
                x1 += 100000;
                x2 += 100000;
                for(int j = x1; j <= x2; j++){
                    tiles[j].plusWhiteCnt();
                    tiles[j].setFinalColor("WHITE");
                }
            }else{
                x1 = start;
                x2 = start + x;
                start = x2-1;
                x1 += 100000;
                x2 += 100000;
                for(int j = x1; j < x2; j++){
                    tiles[j].plusBlackCnt();
                    tiles[j].setFinalColor("BLACK");
                }
            }

        }
        //
        int white = 0;
        int black = 0;
        int gray = 0;
        for(int i = 0; i < 200001; i++){
            if(tiles[i].getBlackCnt() >= 2 && tiles[i].getWhiteCnt() >= 2){
                gray++;
                continue;
            }
            if(tiles[i].getFinalColor().equals("WHITE")){
                white++;
            }else if(tiles[i].getFinalColor().equals("BLACK")){
                black++;
            }
        }

        System.out.println(white + " " + black + " " + gray);
    }

    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tiles = new int[200001];
        int[] cntB = new int[tiles.length];
        int[] cntW = new int[tiles.length];

        int cur = 100000;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            if (command.equals("L")) {
                while (x-- > 0) {
                    tiles[cur] = 1; //white
                    cntW[cur]++;
                    if (x > 0) cur--;
                }
            } else {
                while (x-- > 0) {
                    tiles[cur] = 2;
                    cntB[cur]++;
                    if (x > 0) cur++;
                }
            }
        }
        int w = 0;
        int b = 0;
        int g = 0;
        for(int i = 0; i < 200001;i++){
            if(cntB[i] >= 2 && cntW[i] >= 2) g++;
            else if (tiles[i] == 1) {
                w++;
            } else if (tiles[i] == 2) {
                b++;
            }
        }
        System.out.print(w + " " + b + " " + g);

    }
}
