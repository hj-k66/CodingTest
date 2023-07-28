package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[CodeTree] 객체 정렬 / 키, 몸무게를 기준으로 정렬
 */
public class SortByHeightAndWeight {
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
            if(o.height == this.height){
                return o.weight - this.weight;
            }
            return this.height - o.height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(people);

        for(int i = 0; i < n; i++){
            System.out.println(people[i].name + " " + people[i].height +" " + people[i].weight);

        }
    }
}
