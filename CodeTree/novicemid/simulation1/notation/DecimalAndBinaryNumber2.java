package CodingTest.CodeTree.novicemid.simulation1.notation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalAndBinaryNumber2 {
    static int convertToDecimal(String binary){
        int num = 0;
        for(int i = 0; i < binary.length(); i++){
            num = num * 2 + binary.charAt(i) - '0';
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        int decimal = convertToDecimal(binary) * 17;
        int[] digit = new int[decimal];
        int cnt = 0;
        while(true){
            if(decimal < 2){
                digit[cnt++] = decimal;
                break;
            }
            digit[cnt++] = decimal % 2;
            decimal /= 2;
        }
        for(int i = cnt - 1; i >= 0; i--)
            System.out.print(digit[i]);

    }
}
