package CodingTest.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
[BOJ] 2493 탑
112912KB |	532ms
[문제 해석]
- N개의 높이가 서로 다른 탑 -> 높이가 같은 경우 x
- 각 탑들이 레이저를 왼쪽으로 발사했을 때, 레이저를 수신하는 탑의 번호 출력하는 문제
- 탑의 수(N) : 50만 이하
- 탑의 높이 : 1억이하 정수 => int 형 사용 가능
[문제 풀이]
- 1번 탑부터 진행 => 4번탑의 레이저를 수신하는 탑의 번호를 구할 때,
 3번탑 < 4번탑 => 3번탑이 수신부가 될 일 없음
 2번탑 > 4번탑 => 2번탑이 더 크므로 2번이 수신탑
=> 후입으로 들어온 3번탑의 정보를 먼저 삭제하므로 후입선출인 stack 구조 사용
1. 1번탑부터 N번탑까지 탐색을 시작한다. (입력 받는 것도 여기서)
2. 비교할 탑의 정보가 없는 경우, (스택이 비어있는 경우)
    - 0 출력 후, 스택에 현재 탑 정보 저장
3. 비교할 탑의 정보가 있는 경우,
    1) 스택에서 꺼낸 탑의 높이 < 현재 탑 높이
        - 스택에서 꺼낸 탑의 높이 삭제 후, 2~3번 다시
    2) 스택에서 꺼낸 탑의 높이 > 현재 탑 높이
        - 스택에서 꺼낸 탑의 번호 출력 후, 현재 탑의 정보 스택에 저장 => 1번으로 진행
[시간 복잡도]
O(N)
[최적화]
1. 입력받는 탑의 정보를 배열에 굳이 저장안해도 된다.
2. 출력할 때 StringBuilder로 한꺼번에 출력하기
3. Stack 인터페이스보다는 Deque 활용
 */
public class B2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        //로직
//        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>(); // 0 : 탑 번호, 1 : 탑 높이
        A : for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken()); //현재 탑의 높이
            while (!stack.isEmpty()) {
                int[] topInfo = stack.peek();   //비교할 탑 정보
                if (height < topInfo[1]) {
                    sb.append(topInfo[0]).append(' ');
                    stack.push(new int[]{i + 1, height});
                    continue A;
                } else {
                    stack.pop();
                }
            }
            stack.push(new int[]{i + 1, height});
            sb.append(0).append(' ');
        }

        System.out.println(sb);
    }
}

