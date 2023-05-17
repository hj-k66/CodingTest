package CodingTest.BaekJoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
[BOJ] 9012 괄호
내풀이 : stack 사용
 */
public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '('){
                    stack.add('(');
                }else{
                    if(stack.isEmpty()){
                        stack.add('(');
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }

    /*
    other solution : count 이용
    - Stringbuilder로 한꺼번에 출력
    - 정답 문자열(YES or NO) 리턴하는 함수로 구현
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            sb.append(solve(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }
    static String solve(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
            } else if (count == 0) {
                return "NO";
            }else{
                count--;
            }
        }
        if(count == 0){
            return "YES";
        }else {
            return "NO";
        }
    }
}
