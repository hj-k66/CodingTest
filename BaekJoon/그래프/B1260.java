package CodingTest.BaekJoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[BOJ] DFS와 BFS
 */
public class B1260 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        //그래프 초기화
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 0; i < graph.size(); i++) Collections.sort(graph.get(i));

        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }
    static void dfs(int v){
        //현재 노드 방문 처리
        visited[v] = true;
        System.out.print(v + " ");
        for(int i = 0; i < graph.get(v).size(); i++){
            int x = graph.get(v).get(i);
            if(!visited[x]) dfs(x);
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        //현재 노드 방문 처리
        visited[v] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.add(y);
                    visited[y] = true;
                }
            }
        }
    }
}
