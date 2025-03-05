package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[SWEA] 3289 서로소집합
106,216 kb | 400 ms
 */
public class Solution_3289_서로소집합 {

    static int n,m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parents = new int[n+1];

            makeSet();

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(command == 0){   //합집합
                    union(a,b);
                }
                if(command == 1){
                    // 같은 집합이면
                    if(find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }

            sb.append('\n');
        }
        System.out.println(sb);
    }

    //집합 생성 메소드
    static void makeSet(){
        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }
    }

    //find(a)
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    //union
    static boolean union(int a, int b){
        int aRoot = find(a);    //부모 찾기
        int bRoot = find(b);

        if(aRoot == bRoot) return false;    //루트가 같다면 이미 같은 집합이므로 false

        parents[bRoot] = aRoot; //a집합에 b집합을 포함시킴
        return true;
    }
}
