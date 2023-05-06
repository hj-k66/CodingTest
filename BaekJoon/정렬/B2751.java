package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
[BOJ] 수 정렬하기 2
내 풀이 : Arrays.sort()로 했더니 시간 초과
>> Arrays.sort()는 dual-pivot quicksort, 최악의 시간복잡도가 O(n^2)이라 시간 초과
>> 최악의 경우에도 O(nlogn) 보장, O(n) 정렬 알고리즘 사용
- StringBuilder로 한번에 출력
 */
public class B2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        for (int elem: arr) {
            sb.append(elem).append('\n');
        }
        System.out.println(sb);
    }

    public static void CountSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
        수 범위 : -1000000 ~ 1000000
        */
        boolean[] arr = new boolean[2000001];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]){
                sb.append((i-1000000)).append('\n');
            }
        }
        System.out.println(sb);

    }
}
