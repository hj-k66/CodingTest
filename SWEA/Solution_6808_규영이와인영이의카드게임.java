package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {

    static List<Integer> cardG;   //규영이의 카드
    static List<Integer> cardY;    //인영이의 카드
    static boolean[] visited;
    static int[] cards; //인영이의 카드 경우의 수 저장하는 배열
    static int winCnt;
    static int loseCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test = 1; test <= T; test++){
            st = new StringTokenizer(br.readLine());
            cardG = new ArrayList<>();  //규영이의 카드
            for(int i = 0; i < 9; i++){
                cardG.add(Integer.parseInt(st.nextToken()));
            }
            cardY = new ArrayList<>();//인영이의 카드
            for(int card = 1; card <= 18; card++){
                if(!cardG.contains(card)){    //규영이가 없는 카드는 인영이의 카드
                    cardY.add(card);
                }
            }

            //인영이의 카드로 순열
            visited = new boolean[9];
            cards = new int[9]; //인영이의 카드 경우의 수를 저장
            winCnt = 0;
            loseCnt = 0;
            perm(0);
            System.out.printf("#%d %d %d\n", test, winCnt, loseCnt);
        }
    }

    private static void perm(int idx){
        if(idx == 9){
            //규영이의 카드와 비교
            int sumG = 0;   //규영이 점수
            int sumY = 0;   //인영이 점수
            for(int i = 0;i < 9; i++){
                int currG = cardG.get(i);
                int currY = cards[i];
                if(currG > currY){
                    sumG += (currG + currY);
                }
                if(currG < currY){
                    sumY += (currG + currY);
                }
            }
            if(sumG > sumY) winCnt++;   //규영이가 이기는 경우
            if(sumG < sumY) loseCnt++;  //규영이가 지는 경우
            return;
        }
        for(int i = 0; i < 9; i++){ //인영이의 카드 경우의 수
            if(!visited[i]){
                cards[idx] = cardY.get(i);
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
