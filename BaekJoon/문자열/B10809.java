package CodingTest.BaekJoon.문자열;
import java.io.*;
import java.util.*;
public class B10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet,-1);

        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'a';
            if(alphabet[idx] == -1){
                alphabet[idx] = i;
            }
        }

        //출력
        for(int elem : alphabet){
            System.out.print(elem + " ");
        }
    }
}
