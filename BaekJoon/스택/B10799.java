package CodingTest.BaekJoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
[BOJ] 10799 쇠막대기
내풀이 : 변수 count로 구현, stack x
- 레이저의 닫힌 괄호 : answer+=현재까지의 막대 수
- 막대기의 닫힌 괄호 : answer += 1, 막대 수--
 */
public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int stick = 0;
        int answer = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == '(') {
                if (line[i + 1] == ')') {
                    answer += stick;
                    i++;
                    continue;
                }
                stick++;
            }
            if (line[i] == ')') {
                answer++;
                stick--;
            }
        }
        System.out.println(answer);

    }
    /*
    other solution : 스택 사용
    1. '('일 경우, stack에 push
    2. ')'일 경우, stack에 pop
    2-1. 바로 전 문자가 '('일 경우, 레이저 >> answer += stack.size()
    2-2. 아닐 경우, answer++
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for(int i = 0; i < input.length();i++){
            if(input.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            if(input.charAt(i) == ')'){
                stack.pop();
                if (input.charAt(i-1) == '('){
                    result += stack.size();
                }else{
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
