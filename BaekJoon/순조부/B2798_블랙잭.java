package CodingTest.BaekJoon.순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 2798 블랙잭
11588KB | 	72ms
[문제 풀이]
-  M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력
=> 조합
- 카드를 고르는 중 현재까지의 합이 M을 넘어가면 가지치기
 */
public class B2798_블랙잭 {
    static int N;
    static int M;
    static int max;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        max = 0;
        comb(0,0,0);
        System.out.println(max);
    }

    static void comb(int start,int idx, int sum){
        if(sum > M) return;
        if(idx == 3){
            max = Math.max(max, sum);
            return;
        }
        for(int i = start; i < N; i++){
            comb(i + 1, idx+1,sum + card[i]);
        }
    }
}
