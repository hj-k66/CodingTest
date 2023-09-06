package CodingTest.CodeTree.intermediatelow.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 격자 안에서 터지고 떨어지는 경우 / 1차원 젠가
 */
public class Jenga1d {
    static int n;
    static int endOfJenga;
    static int[] jenga;
    static int[] temp;

    static void cutArray(int startIdx, int endIdx){
        int endOfTemp = 0;

        //구간 외 부분만 temp로 이동 (젠가 제거 및 이동)
        for(int i = 0; i < endOfJenga; i++){
            if(i < startIdx - 1 || i >= endIdx){
                temp[endOfTemp++] = jenga[i];
            }
        }

        //copy
        for(int i = 0; i < endOfTemp; i++){
            jenga[i] = temp[i];
        }
        endOfJenga = endOfTemp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        jenga = new int[n];
        for(int i = 0; i < n; i++){
            jenga[i] = Integer.parseInt(br.readLine());
        }

        //로직
        int time = 2;
        endOfJenga = n;
        temp = new int[n];
        while(time-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            cutArray(s,e);
        }

        //출력
        System.out.println(endOfJenga);
        for(int i = 0; i < endOfJenga; i++){
            System.out.println(jenga[i]);
        }
    }
}
