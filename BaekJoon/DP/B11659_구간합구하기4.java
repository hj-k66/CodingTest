package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 11659 구간 합 구하기 4
	56572KB |	516ms
[문제 해석]
N = 10만, M = 10만
i,j는 1부터 => 즉 인덱스는 0이 아닌 1부터 시작
[문제 풀이]
N과 M이 10만이므로 for문을 돌면서 구간합을 구하면 시간초과 => 10만(M) * 10만(i = 1. j = 10만)
=> O(1)로 끝날 수 있게 연산해야함
=> 누적합으로 계산, 한번만 계산한 후 필요한 부분을 뽑아서 쓴다 (O(1) 연산 가능
=> j까지의 누적합 - i직전까지의 누적합
[시간복잡도]
O(N+M)
 */
public class B11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] number = new int[N+1];
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            number[i] = Integer.parseInt(st.nextToken());
            sum[i] = number[i] + sum[i-1];
        }

        StringBuilder sb = new StringBuilder();
        int i,j;
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            sb.append(sum[j] - sum[i-1]).append("\n");
        }

        System.out.println(sb);
    }
}
