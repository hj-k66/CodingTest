package CodingTest.BaekJoon.구현;

import java.io.*;
import java.util.ArrayList;

public class B10798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> input = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < 5; i++) {
            input.add(br.readLine());
            if(length < input.get(i).length())
                length = input.get(i).length();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 5; j++) {
                if(i >= input.get(j).length()){
                    continue;
                }
                sb.append(input.get(j).charAt(i));
            }
        }
        System.out.println(sb);
    }
}
