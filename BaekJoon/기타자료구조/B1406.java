package CodingTest.BaekJoon.기타자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
[BOJ] 1406 에디터
풀이 : 스택 두개로 풀이
*/
public class B1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int m = Integer.parseInt(br.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        //초기값 왼쪽 stack에 모두 넣기
        String[] arr = input.split("");
        for(String s:arr){
            left.push(s);
        }
        while(m-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("P")){
                String t = st.nextToken();
                left.push(t);
            }
            if(command.equals("L")){
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            }
            if(command.equals("D")){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            }
            if(command.equals("B")){
                if(!left.isEmpty()){
                    left.pop();
                }
            }
        }

        //왼쪽 스택에 있는 데이터를 모두 오른쪽으로 옮김
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
