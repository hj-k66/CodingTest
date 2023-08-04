package CodingTest.CodeTree.novicemid.simulation1.notation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
[CodeTree] Notation / 2진수로 변환하기
 */
public class ConvertToBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] digit = new int[n+1];
        int cnt = 0;
        while(true){
            if(n < 2){
                digit[cnt++] = n;
                break;
            }
            digit[cnt++] = n % 2;
            n /= 2;
        }

        for(int i = cnt - 1; i >= 0; i--){
            System.out.print(digit[i]);
        }
    }
}
