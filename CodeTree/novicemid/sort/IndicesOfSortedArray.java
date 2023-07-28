package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[CodeTree] 객체 정렬 / 정렬된 숫자 위치 알아내기
 */
public class IndicesOfSortedArray {
    static class Number implements Comparable<Number>{
        private int index;
        private int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Number o) {
            if(value == o.value){
                return index - o.index;
            }
            return value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Number[] numbers = new Number[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(st.nextToken());
            numbers[i] = new Number(i,value);
        }

        Arrays.sort(numbers);
        for(int i = 0; i < n; i++){
            rank[numbers[i].index] = i+1;
        }

        //출력
        for(int i = 0; i < n; i++){
            System.out.print(rank[i] + " ");
        }

    }
}
