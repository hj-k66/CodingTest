package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[BOJ] 16435 스네이크버드
11856KB |	76ms
[문제 풀이]
스네이크버드는 자신의 길이보다 작거나 같은 높이에 있는 과일만 먹을 수 있고, 최대 늘일 수 있는 길이를 구해야하므로,
과일들의 높이를 오름차순으로 정렬 한 후, 가장 높이가 작은 과일부터 먹는다.
못먹는 과일이 나올 경우, 그 뒤 과일들도 못 먹기 때문에 해당 길이가 최대 길이가 된다.
 */
public class B16435_스네이크버드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] h = new int[N];
        for(int i = 0; i < N; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        Arrays.sort(h);
        for(int i = 0; i < N; i++){
            if(L < h[i]) break;
            L++;
        }
        System.out.println(L);
    }
}
