package CodingTest.BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
[BOJ] 13023 ABCDE
	19356KB	 | 188ms
[문제 풀이]
- 임의의 정점에서 간선을 따라 5개의 정점을 연속해서 방문할 수 있다면 1 출력, 아니면 0 출력
=> 한 정점에서 DFS 탐색을 진행할 때 이동횟수가 5가 되는지 확인
- 방문 처리한 노드들은 다시 백트래킹할 때 false 처리해줘야 함.
 */
public class B13023_ABCDE {
    static int N;
    static int M;
    static List<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new List[N];
        for(int i = 0; i < N; i++){
            adjList[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        //로직
        visited = new boolean[N];
        for(int start = 0; start < N; start++){
            DFS(start, 1);
        }

        System.out.println(0);


    }

    /**
     * start 정점을 방문하고 start 정점으로부터 인접한 정점에 대한 방문 처리는 재귀로 넘김
     * @param start
     * @param cnt
     */
    static void DFS(int start, int cnt){
        if(cnt == 5) {
            System.out.println(1);
            System.exit(0);
        }

        visited[start] = true;

        for(int next : adjList[start]){
            if(visited[next]) continue;

            DFS(next, cnt + 1);
        }
        visited[start] = false;

    }
}
