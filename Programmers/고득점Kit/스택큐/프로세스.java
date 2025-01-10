package CodingTest.Programmers.고득점Kit.스택큐;

import java.util.*;

/*
[프로그래머스] 프로세스

[문제 풀이]
1. 큐에 {인덱스, 우선순위값} 형태로 넣는다.
2. 큐에서 프로세스를 하나 꺼낸 후 모든 프로세스(priorities 를 돌며 우선순위가 더 높은게 있는지 확인
    1) 더 높은게 있다면 큐에 꺼낸 거 다시 넣기
3. priorities를 다 돌아도 더 높은게 없었다면 꺼냈던 프로세스 실행 answer++;
    - 꺼낸 프로세스 visited 처리
 */
class 프로세스 {
    public static void main(String[] args) {
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;     //현재 몇번째로 실행되고 있는지
        Queue<int[]> q = new ArrayDeque();  // 0 : 인덱스, 1 : 우선순위값
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }
        boolean[] visited = new boolean[priorities.length];
        A:
        while (true) {
            int[] curr = q.poll();
            // 더 높은 우선순위가 있는지 판단
            for (int i = 0; i < priorities.length; i++) {
                if (!visited[i] && curr[1] < priorities[i]) {
                    q.add(curr);
                    continue A;
                }
            }
            // 방금 꺼낸 프로세스 실행
            answer++;
            visited[curr[0]] = true;
            if (location == curr[0]) {
                return answer;
            }
        }
    }

    /*
    [우선 순위 큐 이용 풀이]
    1. 우선 순위가 내림차순이 되게 우선 순위 큐 초기화
    2. priorities를 돌면서 우선순위 큐에서 뽑은 것(가장 우선순위 높은 것)과 같은거 찾기
        - answer++
     */
    static int otherSolution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : priorities) {
            pq.add(num);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // 가장 우선순위가 높은 것
                if (priorities[i] == pq.peek()) {
                    pq.poll();  //제거하기
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

}
