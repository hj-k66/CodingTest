package CodingTest.BaekJoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
[BOJ] 11286 절댓값 힙
28584KB |	364ms
[문제 풀이]
배열 중 절댓값이 가장 작은 것을 출력해야하므로, 우선순위대로 요소를 뽑아야 하므로 우선순위 큐 사용
 */
public class B11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int diff = Math.abs(o1) - Math.abs(o2);
            if(diff == 0){
                return o1 - o2;
            }
            return diff;
        });

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                // 절댓값이 가장 작은 값 출력
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
            else{
                // x값 추가하는 연산
                pq.add(x);
            }
        }

        System.out.println(sb);
    }
}
