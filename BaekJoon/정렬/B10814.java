package CodingTest.BaekJoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
[BOJ] 10814 나이순 정렬
 */
public class B10814 {
    static class Member implements Comparable<Member>{
        int age;
        String name;
        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age,name));
        }

        Collections.sort(members);

        for (Member member: members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.print(sb);
    }
}
