package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[SWEA] 1238 Contact
26,240 kb | 90 ms
[문제 풀이]
인접리스트를 만들고 BFS 진행 => 레벨별 BFS를 진행하며 현재 레벨에서 가장 숫자가 큰 사람 저장
 */
public class SWEA1238_Contact {

    static List<Integer>[] adjList;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            adjList = new List[101];
            for(int i = 0; i <= 100; i++){
                adjList[i] = new ArrayList();
            }

            //입력
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < length/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
            }

            //로직
            visited = new boolean[101];
            int answer = BFS(start);
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static int BFS(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            max = 0;    // 현재 레벨에서 가장 숫자가 큰 사람
            while(size-- > 0){
                int curr = q.poll();
                max = Math.max(max, curr);

                //연결된 노드 확인
                for(int next : adjList[curr]){
                    if(visited[next]) continue;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return max;
    }
}
