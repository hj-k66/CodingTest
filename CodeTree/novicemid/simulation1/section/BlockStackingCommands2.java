package CodingTest.CodeTree.novicemid.simulation1.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 구간 칠하기 / 블럭쌓는 명령 2
 */
public class BlockStackingCommands2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] block = new int[n+1];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //블럭쌓기
            for(int j = a; j <= b; j++){
                block[j]++;
            }
        }

        //최댓값
        int max = 0;
        for(int i = 0; i <= n; i++){
            max = Math.max(max, block[i]);
        }
        System.out.println(max);
    }
}
