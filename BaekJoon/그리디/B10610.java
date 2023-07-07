package CodingTest.BaekJoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
[BOJ] 10610 30
풀이 : 30의 배수 조건
1. 0이 있어야 함.
2. 각 자리수 합이 3의 배수
 */

public class B10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] numCount = new int[10]; //0~9까지의 수 갯수
        long total = 0; //각 자리수 합
        for(int i = 0; i < n.length(); i++){
            int temp = n.charAt(i) - '0';
            numCount[temp]++;
            total += temp;
        }

        if(!n.contains("0") || total % 3 != 0){ //0이 없으면 30의 배수 x
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >=0; i--){
            while(numCount[i] > 0){
                sb.append(i);
                numCount[i]--;
            }
        }
        System.out.println(sb);
    }
}
