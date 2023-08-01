package CodingTest.CodeTree.novicemid.simulation1.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 날짜와 시간 계산 / 요일 맞추기
 */
public class GuessDayOfWeek {
    static int calcNumOfDay(int m, int d){
        int[] dayOfMonth = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        for(int i = 0; i < m-1; i++)
            total += dayOfMonth[i];
        return total + d;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String[] day = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int monday = calcNumOfDay(m1, d1);
        int targetDay = calcNumOfDay(m2, d2);

        if(targetDay >= monday){
            System.out.println(day[(targetDay-monday)%7]);
        }
        else{
            System.out.println(day[7 - 1 * (monday - targetDay)%7]);
        }
    }

    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int diff = calcNumOfDay(m2, d2) - calcNumOfDay(m1, d1);

        while(diff < 0)
            diff += 7;

        // 알맞은 요일의 이름을 출력합니다.
        String[] dayOfWeek = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        System.out.print(dayOfWeek[diff % 7]);

    }
}
