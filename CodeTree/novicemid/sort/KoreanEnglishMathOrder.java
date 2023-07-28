package CodingTest.CodeTree.novicemid.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[CodeTree] 객체 정렬 / 국영수 순이지
 */
public class KoreanEnglishMathOrder{
    static class Student implements Comparable<Student>{
        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(this.korean == o.korean){
                if(this.english == o.english){
                    return o.math - this.math;
                }
                return o.english - this.english;
            }
            return o.korean - this.korean;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students);

        for(int i = 0; i < n; i++){
            System.out.println(students[i].name + " " + students[i].korean + " "
                    + students[i].english + " " + students[i].math);
        }
    }
}
