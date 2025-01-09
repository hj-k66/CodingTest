package CodingTest.BaekJoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
[BOJ] 2164 카드2
 ArrayDeque : 31596KB |	120ms
 LinkedList : 51240KB |	140ms
[문제풀이]
- 들어오는 입구와 나가는 출구가 다르므로 큐를 활용
=> Queue는 ArrayDeque로 구현하는 것이 메모리적으로나 시간상으로나 더 좋음
 */
public class B2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll();   //제일 위에 있는 카드를 버린다.
            // 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
            int top = queue.poll();
            queue.offer(top);

        }

        System.out.println(queue.peek());
    }
}
