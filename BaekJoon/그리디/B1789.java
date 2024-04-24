package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//[BOJ] 1789 수들의 합
// 11516KB |	84ms
public class B1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        long n = 0;
        while(sum <= S){
            n++;
            sum += n;
        }
        System.out.println(n-1);
    }
}
