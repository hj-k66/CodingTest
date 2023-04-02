package CodingTest.BaekJoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        TreeSet<String> suffixs = new TreeSet<>();

        for (int i = 0; i < input.length(); i++) {
            String suff = input.substring(i);
            suffixs.add(suff);
        }

        //출력
        for(String suff : suffixs){
            System.out.println(suff);
        }
    }
}
