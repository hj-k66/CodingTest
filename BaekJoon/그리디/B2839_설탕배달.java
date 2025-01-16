package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 2839 설탕 배달
11564KB | 	64ms
[문제 풀이]
- dp로 3키로가 무조건 포함된 경우와 5키로가 무조건 포함된 경우를 따져 그 중 작은 값을 dp에 넣기
- dp[i] = Math.min(1 + dp[i-3] , 1 + dp[i-5])
 */
public class B2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[N] = -1;
        dp[3] = 1;
        if(N >= 5) dp[5] = 1;

        for(int i = 6; i <= N; i++){
            if(dp[i-3] == 0 && dp[i-5] == 0) continue;

            // 1) 3이 무조건 포함
            int num1  = Integer.MAX_VALUE;
            if(dp[i-3] != 0){
                num1 = 1 + dp[i-3];
            }
            // 2) 5가 무조건 포함
            int num2 = Integer.MAX_VALUE;
            if(dp[i-5] != 0){
                num2 = 1 + dp[i-5];
            }

            dp[i] = Math.min(num1, num2);
        }

        System.out.println(dp[N]);
    }

    /*
    [그리디]
    - 5Kg로 들 수 있으면 가장 적은 봉지로 가지고 갈 수 있기 때문에,
    5로 나누어 떨어지면 카운트 증가 후 종료
    아니면 3키로 하나 포장 후 다시 반복문
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        while(N > 0){
            if(N % 5 == 0){ //5로 나누어 떨어지면
                answer += N / 5;
                break;
            }

            // 3kg 하나 추가
            N -= 3;
            answer++;
        }

        if (N < 0) { // 3,5키로로 만들 수 없는 경우
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}
