package CodingTest.BaekJoon.스택큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[1158] 요세푸스 문제
291840KB |	488ms
[문제 해석]
요세푸스 순열 : 원에서 사람들이 제거되는 순서
N : 1 ~ N번까지 사람
K : K번째 사람 제거
[문제 풀이]
** 큐를 활용한 풀이
- N번째 숫자 다음 1번째로 가야하는 원형적인 구조로, k-1번째까지는 다시 큐에 넣어 뒤로 보냄
 */
public class B1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        // 초기 세팅
        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int num;
        for(int i = 1; i <= N*K; i++){ //k번째를 N번 구해야 하므로 N*K
            num = q.poll();
            if(i%K != 0) q.offer(num); //K번째가 아니므로 뒤로 다시 넣기
            else{
                sb.append(num);
                if(!q.isEmpty()) sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }

    /*
    [리스트를 활용한 풀이]
    - 1~N까지 리스트에 저장 후, K번째 수 삭제 후 인덱스 변화 조절
     */
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = K-1;      //처음에 삭제될 요소의 인덱스

        while(true){
            sb.append(list.remove(idx)).append(", ");

            // 삭제 된 후 남아있는 요소가 없으면 반복 종료
            if(list.size() == 0) break;

            //k번째 삭제 후 인덱스 변화량
            idx += (K-1);  // 하나가 삭제되었기 때문에 K가 아닌 K-1 이동
            idx %= list.size();
        }

        // 맨뒤의 , 를 삭제하기 위함
        //StringBuilder의 길이를 length - 2로 만든다.
        sb.setLength(sb.length() - 2);
        sb.append('>');

        System.out.println(sb);
    }
}
