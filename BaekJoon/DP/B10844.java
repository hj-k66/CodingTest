package CodingTest.BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10844 {
    static int n;
    static Long[][] dp;
    final static long MOD = 1000000000;
    //Top-down 방식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        dp = new Long[n+1][10];

        //첫번째 자릿수는 앞 자릿수에서 이미 구했으니 경우의 수가 하나임
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        //n자릿수에 대해 모든 자릿값에 대한 경우의 수를 구한다.
        for (int i = 1; i <= 9 ; i++) {
            result += recur(n,i);
        }
        System.out.println(result % MOD);

    }

    //digit : 자릿수, val : 자릿값
    static long recur(int digit, int val){
        if(digit == 1){
            return dp[digit][val];
        }

        if(dp[digit][val] == null){
            if(val == 0){
                dp[digit][val] = recur(digit-1, 1);
            } else if (val == 9) {
                dp[digit][val] = recur(digit-1,8);
            }
            //ex) n = 2, dp[2][1] = recur(1,0) + recur(1,2)
            // 2번째 자릿수에 1이 올 경우, 그 다음 수에는 0과 2가 올 수 있으므로, 각 경우를 더해 구한다.
            else{
                dp[digit][val] = recur(digit-1,val-1)+recur(digit-1,val+1);
            }

        }
        return dp[digit][val] % MOD;
    }

    //Bottom-up 방식
    public static void otherSolution(){
        //첫번재 자릿수
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1L;
        }
        //두번째 자릿수 ~ n번째 자릿수
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 9){
                    dp[i][9] = dp[i-1][8]%MOD;
                } else if (j == 0) {
                    dp[i][0] = dp[i-1][1]%MOD;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%MOD;
                }
            }
        }

        long answer = 0;
        for(int i = 0; i < 10; i++){
            answer += dp[n][i];
        }
        System.out.println(answer%MOD);
    }
}
