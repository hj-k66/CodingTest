package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[SWEA] 1225 암호생성기
21,320 kb | 122 ms
[문제풀이]
가장 앞에 있는 값을 가장 뒤로 보내는 문제이기 때문에 Queue 사용
 */
public class SWEA1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < 10; t++){
            int tc = Integer.parseInt(br.readLine());
            int[] arr = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new ArrayDeque<>();
            for(int i = 0; i < 8; i++){
                q.offer(Integer.parseInt(st.nextToken()));
            }

            //로직
            A : while(true){
                for(int d = 1; d <= 5; d++){
                    int num = q.poll();
                    num -= d;
                    if(num <= 0) {
                        q.offer(0);
                        break A;
                    }
                    q.offer(num);
                }
            }

            sb.append('#').append(tc).append(' ');
            for(int i = 0; i < 8; i++){
                sb.append(q.poll()).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
