package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PersonalInfo {
    static class Person{
        private String name;
        private int height;
        private double weight;

        public Person(String name, int height, double weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Person[] people = new Person[5];
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        //이름순 정렬
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        //출력
        System.out.println("name");
        for(int i = 0; i < 5; i++){
            System.out.printf("%s %d %.1f\n", people[i].name, people[i].height, people[i].weight);
        }

        //키 큰 순 정렬
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.height - o1.height;
            }
        });

        //출력
        System.out.println();
        System.out.println("height");
        for(int i = 0; i < 5; i++){
            System.out.printf("%s %d %.1f\n", people[i].name, people[i].height, people[i].weight);
        }
    }
}
