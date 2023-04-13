package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3048 {
    static class Ant {
        char value; //개미 문자
        int direction; // 방향

        public Ant(char value, int direction){
            this.value = value;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        Ant[] group1 = new Ant[n1];
        Ant[] group2 = new Ant[n2];

        String ant1 = br.readLine();
        for (int i = n1-1; i >= 0; i--) {
            group1[i] = new Ant(ant1.charAt(n1-i-1), 1);
        }
        String ant2 = br.readLine();
        for (int i = 0; i < n2; i++) {
            group2[i] = new Ant(ant2.charAt(i),-1);
        }
        int T = Integer.parseInt(br.readLine());
        Ant[] start = new Ant[n1+n2];

        System.arraycopy(group1, 0, start,0,group1.length);
        System.arraycopy(group2, 0, start, n1, group2.length);

        //연산
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < n1+n2-1; j++) {
                Ant a = start[j];
                Ant b = start[j+1];
                if (start[j].direction == 1 && start[j+1].direction == -1){
                    start[j] = b;
                    start[j+1] = a;
                    j++;
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1+n2; i++){
            sb.append(start[i].value);
        }
        System.out.println(sb);

    }
}
