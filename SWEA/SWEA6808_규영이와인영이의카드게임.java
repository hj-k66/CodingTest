package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[SWEA] 6808 규영이와 인영이의 카드 게임
20,388 kb | 4,743 ms
[문제 풀이]
* 순열
1. 카드 수가 고정되어 있고, 서로 중복으로 가지지 않기 때문에 규영이의 카드를 입력 받을 때, boolean 배열로 규영이의 카드 체크
2. 체크한 boolean 배열 값이 false인 것을 인영이의 카드로 저장
3. 순열을 통해 각 라운드로 인영이가 낼 수 있는 경우의 수를 모두 구함
4. 규영이가 이기는 경우와 지는 경우를 count
 */
public class SWEA6808_규영이와인영이의카드게임 {
    static int N = 9;
    static int[] roundIn;   // 라운드 별 제시한 인영이의 카드 - 순열코드로 완성
    static int[] roundGyu;  //라운드 별 제시한 규영이의 카드 - 고정 값
    static int[] cardIn;
    static boolean[] visited;
    static int win;
    static int lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            boolean[] check = new boolean[2*N + 1]; // 규영이의 카드 입력받을 때, 인영이의 카드를 알아내기 위해 boolean 배열 - true의 인덱스 : 규영이의 카드
            roundGyu = new int[N];
            win = 0;
            lose = 0;
            // 규영이의 카드 정보 => 여기에 없는 수는 인영이의 카드 정보
            for(int i = 0; i < N; i++){
                roundGyu[i] = Integer.parseInt(st.nextToken());
                check[roundGyu[i]] = true;
            }
            cardIn = new int[N];
            //인영이의 카드 정보 저장
            int i = 0;
            for(int k = 1; k <= 2*N; k++){
                //false인 인덱스가 인영이의 카드 번호
                if(!check[k]) cardIn[i++] = k;
            }

            roundIn = new int[N];
            visited = new boolean[N];
            perm(0);
            sb.append('#').append(tc).append(' ').append(win).append(' ').append(lose).append('\n');
        }
        System.out.println(sb);
    }

    static void perm(int cnt){
        if(cnt == N){
            // 승패 정하기
            int sumG = 0;
            int sumY = 0;
            for(int i = 0; i < N; i++){
                if(roundGyu[i] > roundIn[i]) sumG += (roundGyu[i] + roundIn[i]);
                if(roundGyu[i] < roundIn[i]) sumY += (roundGyu[i] + roundIn[i]);
            }
            if(sumG > sumY) win++;
            if(sumG < sumY) lose++;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                roundIn[cnt] = cardIn[i];
                visited[i] = true;
                perm(cnt+1);
                visited[i] = false;
            }
        }
    }


}
