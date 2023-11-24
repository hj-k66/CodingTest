package CodingTest.Programmers.LV1;

import java.util.*;

/*
[Programmers] Lv1. 성격유형검사하기
내풀이 : map으로 각 지표별 점수 구한 후, 미리 지정해둔 지표 종류 및 순서따라 결과 출력
- 쌍으로 엮이는 성격지표를 위해 2차원 arrayList 사용
- 3,2,1 -> 1,2,3 으로 바꾸는 코드는 4 - n;
 */
public class 성격유형검사하기 {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        List<List<String>> personality = new ArrayList<>();
        personality.add(List.of("R","T"));
        personality.add(List.of("C","F"));
        personality.add(List.of("J","M"));
        personality.add(List.of("A","N"));

        Map<String, Integer> choiceMap = new HashMap<>();
        for(int i = 0; i < survey.length; i++){
            int choice = choices[i];
            if(choice < 4){ //비동의
                String s = String.valueOf(survey[i].charAt(0));
                choiceMap.put(s, choiceMap.getOrDefault(s,0) + 4 - choice);
            }
            else if(choice > 4){ //동의
               String s = String.valueOf(survey[i].charAt(1));
               choiceMap.put(s, choiceMap.getOrDefault(s, 0) + choice - 4);
            }
        }
        for(List<String> p: personality){

            int v1 = choiceMap.getOrDefault(p.get(0),0);
            int v2 = choiceMap.getOrDefault(p.get(1), 0);

            String result = p.get(0);
            if(v2 > v1){
                result = p.get(1);
            }
            answer += result;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }
}
