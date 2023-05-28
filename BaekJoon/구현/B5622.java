package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            int num = changeToNum(c);
            result += num + 1;
        }

        System.out.println(result);
    }

    public static int changeToNum(char c){
        if(c >='A' && c <= 'C'){
            return 2;
        }
        if(c >= 'D' && c <= 'F'){
            return 3;
        }
        if(c >= 'G' && c <= 'I'){
            return 4;
        }
        if(c >= 'J' && c <= 'L'){
            return 5;
        }
        if(c >= 'M' && c <= 'O'){
            return 6;
        }
        if(c >= 'P' && c <= 'S'){
            return 7;
        }
        if(c >= 'T' && c <= 'V'){
            return 8;
        }
        if(c >= 'W' && c <= 'Z'){
            return 9;
        }
        return 1;
    }
}
