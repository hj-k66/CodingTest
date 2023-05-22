package CodingTest.BaekJoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
[BOJ] 11728 배열 합치기
내풀이 : souf로 하니까 시간 초과 >> StringBuilder로 한번에 출력
 */
public class B11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Long> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        while(n-- > 0){
            arr.add(Long.parseLong(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while(m-- > 0){
            arr.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(arr);

        for (Long elem : arr) {
            sb.append(elem).append(" ");
        }
        System.out.println(sb);
    }
}
