package CodingTest.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] G5 2023 신기한 소수
 */
//	11776KB | 	80ms
public class B2023 {
    static int n;
    static int[] prime = {2,3,5,7};
    static StringBuilder sb;
    static StringBuilder output;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        output = new StringBuilder();
        output.setLength(n);
        for(int i = 0; i < 4; i++){     // 첫자리 수는 무조건 소수
            output.setCharAt(0, (char)(prime[i] + '0'));
            perm(1);
        }

        //출력
        System.out.println(sb);

    }

    static void perm(int idx){
        int num = Integer.parseInt(output.substring(0, idx));
        if(!isPrime(num)) return;
        if(idx == n){
            sb.append(num).append('\n');
            return;
        }

        for(int i = 1; i <= 9; i++){
            output.setCharAt(idx, (char)(i + '0'));
            perm(idx+1);
        }
    }

    static boolean isPrime(int target){
        for(int i = 2; i <= (int)Math.sqrt(target); i++){
            if(target%i == 0){
                return false;
            }
        }
        return true;
    }
}
