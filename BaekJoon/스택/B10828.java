package CodingTest.BaekJoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
[BOJ] 10828 스택
내풀이 : ArrayList로 구현
 */
public class B10828 {
    static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                pop();
            } else if (command.equals("size")) {
                size();
            } else if (command.equals("empty")) {
                empty();
            }else{
                top();
            }

        }
    }
    static void push(int elem){
        stack.add(elem);
    }
    static void top(){
        if(stack.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(stack.get(stack.size()-1));
    }
    static void pop(){
        if(stack.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(stack.remove(stack.size()-1));
    }
    static void size(){
        System.out.println(stack.size());
    }
    static void empty(){
        if(stack.isEmpty()) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
