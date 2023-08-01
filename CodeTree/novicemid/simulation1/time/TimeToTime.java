package CodingTest.CodeTree.novicemid.simulation1.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 날짜와 시간 계산 / Time to Time
풀이 : 두 시간 사이 계산 시, 둘 다 0시 0분으로부터 몇분인지 계산
 */
public class TimeToTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int back = c*60 + d;
        int front = a*60 + b;

        System.out.println(back - front);

    }
}
