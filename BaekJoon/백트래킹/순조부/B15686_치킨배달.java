package CodingTest.BaekJoon.백트래킹.순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
[BOJ] 15686 치킨배달
13000KB |	132ms
[문제 해석]
- NxN 도시 ( 2 <= N <= 50)
- r,c은 1부터 시작
- 각 칸은 빈 칸(0), 치킨집(2), 집(1)
- 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
- 도시의 치킨 거리 : 모든 집의 치킨 거리의 합
=> 목표 : 치킨집 중 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값
[문제 풀이]
0. 치킨집 좌표를 크기 13(최댓값)인 배열에 저장한다. 집의 좌표도 배열에 저장한다.
1. M개의 치킨집을 고른다.
2. M개의 치킨집만 있다고 할 때, 각 집과 치킨집의 거리를 계산해 치킨 거리를 구한다.
3. 모든 집의 치킨 거리의 합을 구하고 최솟값으로 갱신한다.
[시간복잡도]
1. 치킨집 선택 : 13C7 (최대 조합 수는 m=7일때) = 1716
2. 치킨 거리 계산
    - 최대 집 : 2*N = 100
    - 최대 치킨집 : 13
    => 100 * 13 = 1300
=> 1716 * 1300 = 약 230만
[리팩토링]
- 집과 치킨집의 갯수는 동적이므로 배열보단 List가 좋을 듯
- 집과 치킨집 좌표 정보는 이미 각자의 배열, list에 저장되므로 굳이 map[][] 으로 저장할 필요 없다.
 */
public class B15686_치킨배달 {
    static int N;
    static int M;
    static List<Node> chicken;
    static List<Node> home;
    static Node[] selectedChicken;
    static int answer;
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int calcDistance(Node n){
            return Math.abs(this.x - n.x) + Math.abs(this.y - n.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int info = Integer.parseInt(st.nextToken());
                if(info == 2){ //치킨집 좌표 저장
                    chicken.add(new Node(i,j));
                }
                if(info == 1){ //집 좌표 저장
                    home.add(new Node(i,j));
                }
            }
        }

        // 로직
        // 1. 치킨집 M개 뽑기
        selectedChicken = new Node[M];
        answer = Integer.MAX_VALUE;
        comb(0,0);

        System.out.println(answer);

    }

    static void comb(int idx, int start){
        if(idx == M){
            // 2. M개의 치킨집만 있다고 할 때, 각 집과 치킨집의 거리를 계산해 치킨 거리를 구한다.
            int sum = getCityChicken();
            // 3. 모든 집의 치킨 거리의 합을 구하고 최솟값으로 갱신한다.
            answer = Math.min(answer, sum);
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            selectedChicken[idx] = chicken.get(i);
            comb(idx+1, i+1);
        }
    }

    static int getCityChicken(){
        int sum = 0;
        for(Node currHome : home){
            int chickenDistance = Integer.MAX_VALUE;  //가장 가까운 치킨 거리
            for(Node chicken : selectedChicken){
                int distance = currHome.calcDistance(chicken);
                chickenDistance = Math.min(chickenDistance, distance);

            }
            sum += chickenDistance;
        }
        return sum;
    }
}
