package CodingTest.CodeTree.novicemid.simulation1.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 구간 칠하기 / 왔다 갔던 구역 2
 */
public class AreaBeenToAndFrom2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] area = new int[2001];
        int start = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int x1;
            int x2;
            //구간구하기
            if(command.equals("L")){
                x1 = start-x;
                x2 = start;
                start = x1;
            }else {
                x1 = start;
                x2 = start + x;
                start = x2;
            }

            int tempX1 = x1 + 1000;
            int tempX2 = x2 + 1000;
            for(int j = tempX1; j < tempX2; j++){
                area[j]++;
            }
        }

        //2이상인 곳 구하기
        int result = 0;
        for(int i = 0; i < 2001; i++){
            if(area[i] >= 2){
                result++;
            }
        }
        System.out.println(result);

    }
}
