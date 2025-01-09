package CodingTest.BaekJoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// [BOJ] 2493 탑
public class B2493 {
    static class Top {
        int index;
        int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Top> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        A:
        for (int i = 0; i < n; i++) {
            Top curr = new Top(i + 1, Integer.parseInt(st.nextToken()));
            while (!stack.isEmpty()) {
                Top top = stack.peek();
                if (curr.height <= top.height) {
                    sb.append(top.index).append(' ');
                    stack.push(curr);
                    continue A;
                } else {
                    stack.pop();
                }
            }
            stack.push(curr);
            sb.append(0).append(' ');

        }

        System.out.println(sb);
    }
}

