package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[BOJ] 11652 카드
내풀이 : 해쉬맵으로 <카드숫자, 나온 횟수> 저장 >> max 값 갱신
 */
public class B11652{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> cards = new HashMap<>();
        long max = 0;
        long result = 0;
        while(n-- > 0){
            long num = Long.parseLong(br.readLine());
            cards.put(num, cards.getOrDefault(num,0) + 1);

            if(cards.get(num) > max){
                max = cards.get(num);
                result = num;
            } else if (cards.get(num) == max) {
                result = Math.min(result, num);
            }
        }
        System.out.println(result);
    }
}
