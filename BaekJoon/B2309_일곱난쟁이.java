package CodingTest.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[BOJ] 2309 일곱난쟁이
11948KB | 72ms
[문제 풀이]
재귀로 해결 => 순열이 아닌 조합으로 해결해야 함(순서에 의미 없으므로)

 */
public class B2309_일곱난쟁이 {
    static int[] dwarf;
    static int[] output;
    static int N = 9;
    static int R = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[N];
        output = new int[R];
        for(int i = 0; i < N; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        rec(0,0, 0);
    }

    static void rec(int sum, int index, int start){
        if(index == R){
            if(sum == 100){
                Arrays.sort(output);
                for(int i = 0; i < R; i++){
                    System.out.println(output[i]);
                }
                System.exit(0);
            }
            return;
        }
        // 가지치기
        // 7개 선택하지도 않았는데 이미 합이 100이 넘어가면 고려 x
        else if(sum > 100) return;

        for(int i = start; i < N; i++){
            output[index] = dwarf[i];
            rec(sum + output[index], index + 1, start + 1);
        }
    }

    /*
    [반복문-최적화 풀이]
    7명을 뽑는 것이 아닌 2명을 뽑아
    모자의 총합 - 2명의 모자합 = 100 이 되는 경우 구하기
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[N];
        output = new int[N];
        int total = 0;
        for(int i = 0; i < N; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
            total += dwarf[i];
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(total - dwarf[i] - dwarf[j] != 100) continue;

                // 나머지 7난쟁이 출력
                dwarf[i] = 0;
                dwarf[j] = 0;
                Arrays.sort(dwarf);
                for(int k = 2; k < N; k++){
                    System.out.println(dwarf[k]);
                }
                return;
            }
        }
    }
}
