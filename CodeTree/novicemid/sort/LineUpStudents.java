package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[CodeTree] 객체 정렬 / 줄 세우기
 */
public class LineUpStudents {
    static class Student implements Comparable<Student>{
        private int height;
        private int weight;
        private int number;


        public Student(int height, int weight, int number) {
            this.height = height;
            this.weight = weight;
            this.number = number;
        }

        @Override
        public int compareTo(Student o) {
            if(o.height == this.height){
                if(o.weight == this.weight){
                    return this.number - o.number;
                }
                return o.weight - this.weight;
            }
            return o.height - this.height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), i+1 );
         }

        Arrays.sort(students);

        //출력
        for(int i = 0; i < n; i++){
            System.out.println(students[i].height +" " + students[i].weight + " " + students[i].number);
        }
    }
}
