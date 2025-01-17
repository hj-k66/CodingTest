package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[SWEA] 4012 요리사
21,696 kb | 231 ms
[문제 풀이]
1. A요리의 N/2개 식재료 뽑기
- 조합이용, boolean배열로 true인 것은 A요리, false인 것은 B요리로 판단
2. A음식의 시너지합과 B음식의 시너지 합 구하고 맛의 차이 구하기
- 식재료 2개로 시너지를 구해야하므로 이중 for문을 돌려 각 음식의 모든 재료 별 시너지 합 구하기
3. 현재 구한 맛 차이가 최솟값이라면 갱신
[시간 복잡도]
1. 식재료 뽑기
- nCn/2 = 16C8 = 12870
2. A,B 요리의 시너지 합 구하고 맛의 차이 구하기
- N*N = 16*16 = 256
=> 12870*256 = 약 300만
 */
public class SWEA4012_요리사 {
    static int N;
    static boolean[] isSelected;
    static int[][] synergy;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            synergy = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //로직
            isSelected = new boolean[N];
            answer = Integer.MAX_VALUE;
            comb(0, 0);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static void comb(int idx, int start) {
        if (idx == N / 2) {
            int diff = getDiff();
            answer = Math.min(answer, diff);
            return;

        }

        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            comb(idx + 1, i + 1);
            isSelected[i] = false;
        }
    }

    // A,B 음식의 각 맛을 구하고 맛 차이 반환
    static int getDiff() {
        int mealA = 0;
        int mealB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isSelected[i] && isSelected[j]) {
                    mealA += synergy[i][j];
                } else if (!isSelected[i] && !isSelected[j]) {
                    mealB += synergy[i][j];
                }
            }
        }

        return Math.abs(mealA - mealB);

    }
}
