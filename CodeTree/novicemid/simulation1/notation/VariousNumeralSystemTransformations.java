package CodingTest.CodeTree.novicemid.simulation1.notation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VariousNumeralSystemTransformations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] digit = new int[n+1];
        int cnt = 0;
        while(true){
            if(n < b){
                digit[cnt++] = n;
                break;
            }
            digit[cnt++] = n % b;
            n /= b;
        }

        for(int i = cnt - 1; i >= 0; i--){
            System.out.print(digit[i]);
        }
    }
}
