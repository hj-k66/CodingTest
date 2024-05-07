import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_KRUSKAL {
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);	//음의 가중치 고려
		}
		
	}
	
	static int V;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		} // 간선리스트 생성
		
		//전처리 : 간선리스트 오름차순으로 정렬
		Arrays.sort(edgeList);
		
		// 1. make-set
		makeSet();
		
		int weightSum = 0;
		int cnt = 0;
		// 2. 정렬된 간선 하나씩 꺼내어 신장 트리 생성
		for (Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue;	// 사이클 발생
			
			weightSum += edge.weight;
			if(++cnt == V-1) break;	//최소신장트리 완성
		}
		
		System.out.println(weightSum);
	}
	
	public static void makeSet() {
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	public static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if(parentA == parentB) return false;	//a,b가 같은 트리에 속해있다 -> union 불필요
		
		parents[parentA] = parentB;
		return true;
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
}
