package CodingTest.BaekJoon.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
BOJ 1924 2007년
풀이
- 요일 상수 String 배열을 선언
- 총 일수를 구하고 이를 7로 나눈 나머지를 요일 배열의 인덱스로 지정
2월 1일 >> 31 + 1 = 32일  >> 32/7 ... 4 >> 목
3월 1일 =  1월(31) + 2월(28) + 1 >> 60 / 7 ...4 목
 */
public class B1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalDays = 0;

        String[] DAYNAME = new String[]{"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] MONTHDAYS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        if (month == 1) {
            System.out.println(DAYNAME[day % 7]);
        } else {
            for (int i = 0; i < month-1; i++) {
                totalDays += MONTHDAYS[i];
            }
            totalDays += day;
            System.out.println(DAYNAME[totalDays % 7]);
        }
    }
}
