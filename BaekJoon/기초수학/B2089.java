package CodingTest.BaekJoon.기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[BOJ] 2089 -2진수
내풀이 : 나머지를 양수로 만들기 위해, -2로 나눴을 때, 나누어 떨어지지 않으면 n-1하고 -2로 나눔
 */
public class B2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(n == 0){
            System.out.println(0);
            return;
        }

        while(n!=1){
            if(n%(-2) != 0){
                sb.append(1);
                n = (n-1)/(-2);
            }else {
                sb.append(0);
                n /= (-2);
            }
        }
        sb.append(n);
        System.out.println(sb.reverse());
    }
}
