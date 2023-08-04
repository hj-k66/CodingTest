package CodingTest.CodeTree.novicemid.simulation1.notation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[CodeTree] Notation / 10진수로 변환하기
 */
public class ConvertToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();

        int num = 0;
        for(int i = 0; i < binary.length(); i++){
            num = num * 2 + binary.charAt(i) - '0';
        }
        System.out.println(num);
    }
}
