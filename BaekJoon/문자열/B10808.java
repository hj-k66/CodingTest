package CodingTest.BaekJoon.문자열;
import java.io.*;
public class B10808 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] map = new int[26]; //알파벳 갯수

        System.out.println('b' - 'a');
        for (int i = 0; i < input.length(); i++) {
            map[input.charAt(i) - 'a'] += 1;
        }

        //출력
        for (int j : map) {
            System.out.print(j + " ");
        }

    }
}
