package CodingTest.BaekJoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if (ch < 'n') {
                    ch += 13;
                }else {
                    ch -= 13;
                }
            } else if (ch >= 'A' && ch <='Z') {
                if(ch < 'N'){
                    ch += 13;
                }else{
                    ch -= 13;
                }
            }
            sb.append(ch);
        }

        System.out.println(sb);
    }
}
