package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[SWEA] 1247 최적 경로
20,028 kb | 1,556 ms
[문제 풀이]
N이 2이상 10이하이므로 순열로 풀 수 있음 => 고객의 집에 방문하는 순서는 순열로 구한다.
=> 순열 재귀 함수의 매개변수로 현재까지의 거리 합을 구한다. 이를 위해 매개변수로 이전 노드도 넘겨 준다.
 */
public class SWEA1247_최적경로 {
    static int N;
    static Coord company;
    static Coord home;
    static Coord[] customer;
    static boolean[] selected;
    static int answer;

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Coord c){
            return Math.abs(this.x - c.x) + Math.abs(
                    this.y - c.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            company = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customer = new Coord[N];
            for (int i = 0; i < N; i++) {
                customer[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 로직
            selected = new boolean[N];
            answer = Integer.MAX_VALUE;
            perm(0, 0, company);    //회사 ~ N개의 집까지의 거리 구하기

            //출력
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    /**
     *
     * @param idx 방문할 고객 집의 순서
     * @param sum 현재까지 방문했을 때의 거리
     * @param prev 이전에 선택한 고객 집 정보
     */
    static void perm(int idx, int sum, Coord prev) {
        if (idx == N) {
            // 마지막 집 - 집
            sum += prev.getDistance(home);
            // 최단거리 갱신
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!selected[i]) {
                Coord pick = customer[i];
                selected[i] = true;
                perm(idx + 1, sum + pick.getDistance(prev), pick);
                selected[i] = false;
            }
        }
    }
}
