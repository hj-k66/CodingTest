package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[SWEA] 5215 햄버거 다이어트
20,316 kb | 183 ms
[문제 풀이]
* r이 정해지지 않은 조합이므로 부분집합 문제
- 주어진 제한 칼로리 이하 조합 중에서 가장 맛에 대한 점수가 높은 햄버거 점수를 구해야 하므로,
문제 해결 조건인 칼로리와 점수의 합을 재귀함수의 매개변수로 넘긴다.
- 현재까지 선택된 재료들의 칼로리 합이 이미 제한 칼로리를 넘었다면 가지치기
- 모든 재료가 다 고려되었다면 매개변수로 저장해온 점수의 합을 최대값으로 갱신
=> isSelected없음 : 이미 문제에서 필요한 조합은 매개변수로 처리했기 때문에 굳이 기록할 필요 없음
 */
public class SWEA5215_햄버거다이어트 {

    static int N;   //재료의 수
    static int L;   // 제한 칼로리
    static int[][] ingredient;  // 0 : 재료 맛 점수, 1 : 칼로리
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredient = new int[N][2];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                ingredient[i][0] = Integer.parseInt(st.nextToken());
                ingredient[i][1] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            subSet(0,0,0);

            //출력
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }


    /**
     * 주어진 제한 칼로리 이하 조합 중에서 가장 맛에 대한 점수가 높은 햄버거 점수
     * @param cnt 선택/비선택 결정할 요소의 인덱스
     * @param calorie 현재까지 선택된 재료의 칼로리
     * @param score 현재까지 선택된 재료의 점수
     */
    static void subSet(int cnt, int calorie, int score){
        // 가지 치기 : 현재까지 선택된 재료가 이미 제한 칼로리를 넘겼을 때
        if(calorie > L) return;
        if(cnt == N){ // 모든 재료가 선택되었을 때
            answer = Math.max(answer, score);
            return;
        }
        // cnt번째 재료가 선택되었을 때
        subSet(cnt + 1, calorie + ingredient[cnt][1], score + ingredient[cnt][0]);

        // cnt번째 재료가 선택되지 않았을 때
        subSet(cnt + 1, calorie, score);
    }
}
