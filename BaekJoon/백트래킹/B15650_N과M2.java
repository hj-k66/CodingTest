package CodingTest.BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[BOJ] 15650 N과 M(2)
	11528KB | 	68ms
[문제 해석]
N, M : 1~8사이 자연수
[문제 풀이]
- 백트래킹 문제
오름차순으로 수열을 생성해야하므로, 이전 자리 수보다 작은 수는 볼 필요 x
=> for문 시작점이 재귀함수 매개변수로 필요
중복체크배열은 필요없음.
- index++과 같이 쓰면 안됨. 왜냐하면 index 자체 값이 증가하기 때문에 재귀호출에서 빠져나올 때도 증가된 값이 그대로 남게 됨.
 */
public class B15650_N과M2 {
    static int N;
    static int M;
    static int[] output;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        output = new int[M];

        rec(1,0);

        System.out.println(sb);

    }

    static void rec(int num, int index){
        if(index == M){
            for(int i = 0; i < M; i++){
                sb.append(output[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int no = num; no <= N; no++){
            output[index] = no;
            rec(no+1, index+1);
        }

    }
}
