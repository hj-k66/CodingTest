package CodingTest.CodeTree.novicemid.simulation2.ArrayRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
[CodeTree] 배열 기록 / 악수와 전염병의 상관관계 2
 */
public class CorrelationBetweenShakingHandsAndInfectiousDiseases2 {

    static int[] developers;
    static int[] diseasesNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> commands = new ArrayList<>();
        for(int i = 0;i < t; i++){
            st  = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ArrayList<Integer> shakingHand = new ArrayList<>();
            shakingHand.add(time);
            shakingHand.add(x);
            shakingHand.add(y);
            commands.add(shakingHand);
        }

        Collections.sort(commands, (o1, o2) -> {
            return o1.get(0) - o2.get(0); //command 시간 순으로 정렬
        });

        developers = new int[n+1];
        developers[p] = 1;
        diseasesNum = new int[n+1];
        for (ArrayList<Integer> shakingHand:commands) {
            int x = shakingHand.get(1);
            int y = shakingHand.get(2);
            if(developers[x] == 1){
                diseasesNum[x]++;
            }
            if(developers[y] == 1){
                diseasesNum[y]++;
            }

            if(diseasesNum[x] <= k && developers[x] == 1){
                developers[y] = 1;
            }
            if(diseasesNum[y] <= k && developers[y] == 1){
                developers[x] = 1;
            }
        }
        //출력
        for(int i = 1; i <= n; i++){
            System.out.print(developers[i]);
        }


    }
}
