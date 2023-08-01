package CodingTest.CodeTree.novicemid.simulation1.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[CodeTree] 날짜와 시간 계산 / DateTime to DateTime
풀이 : 모두 분으로 환산
 */
public class DateTimeToDateTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int diff = (a*24 * 60 + b * 60 + c) - (11*24*60 + 11*60 + 11);

        if(diff < 0){
            System.out.println(-1);
        }
        else{
            System.out.println(diff);
        }

    }
}
