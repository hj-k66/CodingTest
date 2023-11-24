package CodingTest.Programmers.LV1;

import java.util.*;

/*
[Programmers] Lv 1. 개인정보 수집 유효기간
내풀이 : 연,월,일 비교할 때 일(day)로 변환하여 총 일수로 비교연산
 */

public class 개인정보수집유효기간 {

    public static int calculateDay(String[] date){
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year * 12 * 28) + month * 28 + day;
    }
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] splitedToday = today.split("[.]");
        int todayDate = calculateDay(splitedToday);
        Map<String, Integer> term = new HashMap<>();

        //약관정보
        for(String t : terms){
            String[] s = t.split(" ");
            term.put(s[0], Integer.parseInt(s[1]));
        }

        //개인정보 탐색
        for(int i = 0; i < privacies.length; i++){
            String[] splited = privacies[i].split(" ");
            String[] date = splited[0].split("[.]");
            int day = calculateDay(date);
            String privacyTerm = splited[1];
            int termMonth = term.get(privacyTerm);
            int termDay = day + termMonth * 28;

            //파기할 개인정보
            if(todayDate > termDay){
                answer.add(i+1);
            }

        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(solution(today, terms, privacies));
    }
}
