package CodingTest.CodeTree.novicemid.simulation1.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 날짜와 시간 계산 / Date to Date
 */
public class DateToDate {

    static int calcNumOfDays(int m, int d){
        int[] dayOfMonth = new int[]{31,28,31,30,31,30,31,31,30,31, 30, 31};
        int total = 0;
        for(int i = 0; i < m-1; i++)
            total += dayOfMonth[i];
        total += d;

        return total;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());


        System.out.println(calcNumOfDays(m2,d2) - calcNumOfDays(m1,d1) + 1);
    }
}
