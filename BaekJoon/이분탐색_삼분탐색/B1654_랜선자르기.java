package CodingTest.BaekJoon.이분탐색_삼분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 1654 랜선 자르기
15180KB |	124ms
[문제 풀이]
- 랜선의 길이에 대해 이분탐색을 진행한다.
    - 탐색 범위 조건은 랜선의 갯수로 판단한다.
        -  랜선의 갯수는 모든 랜선을 돌며 판단할 길이(mid)를 나눠 갯수를 구한다.
    1)  랜선의 갯수가 N보다 크거나 같으면 최대 길이를 갱신하며, 더 긴 길이가 나올 수 있으므로 더 큰 범위를 탐색한다.(start = mid + 1)
    2) 랜선의 갯수가 N보다 작으면 랜선의 길이를 줄여야하므로 더 작은 범위를 탐색한다. (end = mid -1)
    -  이분탐색 쓰는 이유 : 탐색의 타겟이 되는 랜선의 길이는 최대 2^31-1이므로 단순 선형탐색을 진행할 경우 시간 초과가 날 것이다.
- 최대 길이를 찾아야 하는 문제이므로 이분탐색 조건에 등호를 포함하여 끝까지 탐색을 수행한다.
[시간복잡도]
이분탐색의 시간복잡도 : O(logN)

 */
public class B1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // 이미 가지고 있는 랜선 갯수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선 갯수

        int[] line = new int[K];
        long max = 0;
        for(int i = 0; i < K; i++){
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(line[i], max);
        }

        //로직
        // 모두 같은 길이의 랜선 N개 이상 만들기
        // 만들 수 있는 랜선의 최대 길이
        long start = 1;
        long end = max;
        int maxLength = 1;

        while(start <= end){
            long mid = (start + end) / 2;

            int cnt = 0;
            for(int i = 0; i < K; i++){
                cnt += line[i] / mid;
            }

            if(cnt >= N) {
                maxLength = (int) mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        System.out.println(maxLength);
    }
}
