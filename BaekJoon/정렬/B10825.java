package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
[BOJ] 10825 국영수
내풀이 : String.compareTo(String) 사용
 */
public class B10825 {
    static class Student implements Comparable<Student> {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        /*
        국어 점수가 감소하는 순서로
        국어 점수가 같으면 영어 점수가 증가하는 순서로
        국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
         모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
         */
        @Override
        public int compareTo(Student o) {
            if (this.koreanScore != o.koreanScore) {
                return o.koreanScore - this.koreanScore;
            }
            if (this.englishScore == o.englishScore) {
                if (this.mathScore == o.mathScore) {
                    return this.name.compareTo(o.name);
                }
                return o.mathScore - this.mathScore;
            }
            return this.englishScore - o.englishScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());
            Student student = new Student(name, koreanScore, englishScore, mathScore);
            students.add(student);
        }

        Collections.sort(students);

        //출력
        for (Student student : students) {
            sb.append(student.name).append("\n");
        }
        System.out.print(sb);
    }
}
