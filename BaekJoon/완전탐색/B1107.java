package CodingTest.BaekJoon.완전탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[BOJ] 1107 리모컨
내풀이 : 자릿수 하나하나보면서 고장난 버튼 아니면 그대로,
고장난 버튼이면 해당버튼 + 1 OR -1 >> 틀림
- 모든 채널 경우의 수 check
 */
public class B1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] wrongButtons = new boolean[10];
        if(m!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < m; i++){
                int index = Integer.parseInt(st.nextToken());
                wrongButtons[index] = true;
            }
        }

        int answer = Math.abs(n-100);
        for (int i = 0; i < 999999; i++) {
            String s = String.valueOf(i);
            boolean isWrong = false;
            for(int j = 0; j < s.length(); j++){
                if(wrongButtons[s.charAt(j) - '0']){
                    isWrong = true;
                    break;
                }
            }
            if(!isWrong){
                int min = Math.abs(n - i) + s.length();
                answer = Math.min(min, answer);
            }
        }
        System.out.println(answer);
    }
}
