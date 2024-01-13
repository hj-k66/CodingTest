package CodingTest.SWEA;

import java.util.Scanner;

/*
[SWEA] 1959. 두 개의 숫자열
 */
public class TwoStringsOfNumbers {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++){
                b[i] = sc.nextInt();
            }
            int minIdx = n;
            int maxIdx = m;
            int[] minArr = a;
            int[] maxArr = b;
            if(n > m){
                maxIdx = n;
                minIdx = m;
                minArr = b;
                maxArr = a;
            }
            int answer = 0;
            for(int i = 0; i <= maxIdx - minIdx; i++){
                int tmp = 0;
                for(int j = 0; j < minIdx; j++){
                    tmp += minArr[j] * maxArr[i+j];
                }
                answer = Math.max(tmp, answer);
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
