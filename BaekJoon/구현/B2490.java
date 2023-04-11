package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int baeCnt = 0;
            int dCnt = 0;
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) baeCnt++;
                if(num == 1) dCnt++;
            }
            if(dCnt == 4) System.out.println("E");
            else if (baeCnt == 4) System.out.println("D");
            else if (baeCnt == 3) System.out.println("C");
            else if (baeCnt == 2) System.out.println("B");
            else  System.out.println("A");
        }
    }
}
