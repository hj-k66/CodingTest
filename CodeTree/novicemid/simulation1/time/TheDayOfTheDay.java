package CodingTest.CodeTree.novicemid.simulation1.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] 날짜와 시간 계산 / 그 요일은
내풀이 : 날짜 일수 차이 나눈 결과 + 남은 요일 결과
 */
public class TheDayOfTheDay {
    static int calcDayOfMonth(int m, int d){
        int[] numOfMonth = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        for(int i = 0; i < m-1; i++)
            total += numOfMonth[i];
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
        String day = br.readLine();
        String[] week = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int dayIdx = 0;
        for(int i = 0; i < 7; i++){
            if(day.equals(week[i])){
                dayIdx = i;
            }
        }
        int diff = calcDayOfMonth(m2, d2) - calcDayOfMonth(m1, d1);
        int result = diff / 7;
        if(diff%7 >= dayIdx){
            result++;
        }
        System.out.println(result);
    }
}
