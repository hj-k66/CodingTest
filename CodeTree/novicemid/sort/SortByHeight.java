package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[CodeTree] 객체 정렬 / 키를 기준으로 정렬
 */
public class SortByHeight {
    static class Person implements Comparable<Person>{
        private String name;
        private int height;
        private int weight;

        public Person(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }


        @Override
        public int compareTo(Person o) {
            return this.height - o.height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        for(int i = 0; i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(persons);

        //출력
        for(int i = 0; i < n; i++){
            System.out.println(persons[i].name + " " + persons[i].height + " "
                    + persons[i].weight);
        }
    }
}
