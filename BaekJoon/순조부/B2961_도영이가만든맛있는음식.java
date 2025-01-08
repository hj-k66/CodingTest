package CodingTest.BaekJoon.순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2961 도영이가 만든 맛있는 음식
11456KB | 	64ms
[문제 해석]
목표 : 신맛과 쓴맛의 차이가 가장 작은 요리의 차이
신맛(S) : 재료의 신맛의 곱
쓴맛(B) : 재료의 쓴맛의 곱
- 재료는 하나 이상 사용
[문제 풀이]
* 조합을 이용한 부분집합 구현
*** 부분집합인 이유 : 원소들의 그룹 중 최적의 부분집합(r이 정해지지 않음)을 구하는 문제이기 때문
- 1 ~ N개의 재료를 뽑는 경우의 수 계산 => 1 ~ N까지 조합 돌리기
- 모든 재료를 합쳐 신맛, 쓴맛을 구해도 10억 이하이므로 int형 써도 됨 (int 약 21억)
 */
public class B2961_도영이가만든맛있는음식 {
    static int N;
    static int[] output;
    static int[][] flavor;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flavor = new int[N][2]; // 0 : 신맛, 1 : 쓴맛
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            flavor[i][0] = Integer.parseInt(st.nextToken());
            flavor[i][1] = Integer.parseInt(st.nextToken());
        }

        //로직
        output = new int[N];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            comb(i+1, 0,0);
        }

        System.out.println(answer);
    }

    static void comb(int count, int start, int index){
        if(index == count){
            int sour = 1;
            int bitter = 0;
            for(int i = 0; i < count; i++){
               sour *= flavor[output[i]][0];
               bitter += flavor[output[i]][1];
            }

            answer = Math.min(Math.abs(sour - bitter), answer);
            return;
        }

        for(int i = start; i < N; i++){
            output[index] = i;
            comb(count, i + 1, index + 1);
        }

    }

    static boolean[] isSelected;
    /**
     * 재귀를 이용한 부분집합 구하기
     * @param cnt 비선택/선택을 완료한 갯수 or 현재 선택/비선택을 고려할 요소의 인덱스
     * @param selNum 선택된 재료 수 (아무것도 선택하지 않은 경우를 거르기 위해)
     */
    static void subSet(int cnt, int selNum){
        // 모든 재료의 선택/비선택이 완료되었을 떄
        if(cnt == N){
            // 선택한 재료가 1개 이상인 경우 (공집합 제외)
            if(selNum >= 1){
                // 선택된 재료의 신맛 쓴맛 차이 계산
                int diff = calcDiff();
            }
            return;
        }

        // cnt 번째 재료 선택하는 경우
        isSelected[cnt] = true;
        subSet(cnt + 1, selNum + 1);

        // cnt 번째 재료 선택하지 않는 경우
        isSelected[cnt] = false;
        subSet(cnt+1, selNum);
    }

    static int calcDiff(){
        int sour = 1; //신맛
        int bitter = 0; //쓴맛
        for(int i = 0; i < N; i++){
            //선택된 재료들의 신맛, 쓴맛 합 구하기
            if(isSelected[i]){
                    sour *= flavor[i][0];
                    bitter += flavor[i][1];
            }
        }
        return Math.abs(sour - bitter);
    }


    /**
     * flag : arr 요소의 선택/비선택 정보를 담고 있음 (flag 자체가 곧 하나의 경우의 수를 의미
     * 나올 수 있는 모든 flag를 확인하는데, 각 비트의 자리를 for문 돌면서 확인(j for문)
     */
    static void binaryCounting(){
        for(int flag = 1; flag < 1 << N; flag++){
            int sour = 1;
            int bitter = 0;
            /*
            j변수를 이용해 flag 비트를 0번자리부터 탐색(값이 1인 경우 해당 식재료를 선택한 경우임)
             */
            for(int j = 0; j < N; j++){
                if((flag & 1 << j) != 0){
                    sour *= flavor[j][0];
                    bitter += flavor[j][1];
                }
            }

            int diff = Math.abs(sour - bitter);
            answer = Math.min(diff, answer);
        }
    }
}
