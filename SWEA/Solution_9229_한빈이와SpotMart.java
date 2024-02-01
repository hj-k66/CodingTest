package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

    static int max;
    static int n;
    static int m;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            weight = new int[n];
            for(int i = 0; i < n; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }
            // 조합 : n개 중 2개를 뽑는 경우 -> 2개의 무게 합이 m보다 작거나 같은 경우 중 최대합
            max = 0;
            comb(0,0,0);
            if(max == 0) max = -1;
            System.out.println("#" + test + " " + max);
        }
    }

    private static void comb(int idx, int start, int sum){
        if(idx == 2){   //무조건 2개 뽑기
            if(sum <= m){   //2개의 무게 합이 m보다 작거나 같은 경우
                max = Math.max(sum, max);
            }
            return;
        }

        for(int i = start; i < n; i++){
            comb(idx + 1, i+1, sum + weight[i]); // 과자 무게의 합 누적
        }
    }
}
