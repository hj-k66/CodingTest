package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Long> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(n-- > 0){
            arr.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(arr);
        System.out.println(arr.get(k-1));
    }
}
