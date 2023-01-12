package CodingTest.BaekJoon.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }
        System.out.println(sum);
    }
}
