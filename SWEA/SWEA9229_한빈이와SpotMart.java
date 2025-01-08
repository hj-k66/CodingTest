package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[SWEA] 9229 한빈이와 Spot Mart
25,740 kb | 179 ms
[문제 해석]
목표 : 2개의 과자를 고르는데, 무게 M그램을 초과하지 않으면서 최대 무게 합 구하기
N : 과자 봉지 갯수(1000)
M : 과자 무게 합 제한 (200만)
각 과제 봉지 무게 : 100만
[문제 풀이]
재귀(조합)로 모든 경우의 수 탐색하면서 과자 2개를 뽑기
- 매개변수로 과자의 합을 넘겨, output[] 안써도 되고, 과자 하나의 무게가 M 초과이면 return하게 가지치기 가능
 */
public class SWEA9229_한빈이와SpotMart {
    static int N;
    static int M;
    static int[] snack;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }

            //로직
            // 2개의 과자를 고르는데, 무게 M그램을 초과하지 않으면서 최대 무게 합 구하기
            answer = -1;
            comb(0,0,0);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static void comb(int start, int index, int sum){
        //무게합이 M 초과이면 x
        if(sum > M) return;
        if(index == 2){
            answer = Math.max(answer,sum);
            return;
        }

        for(int i = start; i < N; i++){
            comb(i+1, index+1, sum + snack[i]);
        }
    }

    /*
    [투포인터]
    - 기본 아이디어 : 가장 가벼운 무게와 가장 무거운 무게의 합이 최대합이다. => 무게 2개 투포인터
    1. 과자 무게 오름차순 정렬
    2. 두개의 포인터 사용
        start = 0
        end = N-1
     - 가장 가벼운 과자, 가장 무거운 과자의 무게 총합 비교
    3. start와 End가 교차할 때까지 반복
    a. 무게의 종합이 M보다 큰 경우
        - 더 가벼운 무게로 시도
         => N-1과자에서 N-2과자로 바꾸기 end--
    b. 무게의 총합이 M보다 작은 경우
        - 현재 값이 최대라면 갱신
        - 현재무게가 최댓값이라는 보장이 없으므로 더 무거운 무게도 시도
        => 0과자에서 1과자 선택 start++
     c. 무게 총합이 M인 경우
        - 선택할 수 있는 최대 무게이므로 더 이상 선택 x => 출력 후 종료
     */
    static void otherSolution(){
        Arrays.sort(snack);

        int start = 0;
        int end = N-1;
        int max = -1;
        while(start < end){
            int sum = snack[start] + snack[end];
            if(sum > M) end--;
            else if(sum < M){
                max = Math.max(max, sum);
                start++;
            }
            else{
                max = sum;
                break;
            }
        }
    }
}
