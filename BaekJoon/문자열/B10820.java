package CodingTest.BaekJoon.문자열;

import java.io.*;

public class B10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            int lower = 0;
            int upper = 0;
            int number = 0;
            int blank = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if(ch >= 'a' && ch <= 'z') lower++;
                if(ch >= 'A' && ch <= 'Z') upper++;
                if(ch == ' ') blank++;
                if(ch >= '1' && ch <= '9') number++;
            }
            System.out.printf("%d %d %d %d\n", lower, upper, number, blank);

        }
    }
}
