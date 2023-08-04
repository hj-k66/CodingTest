package CodingTest.CodeTree.novicemid.simulation1.notation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[CodeTree] Notation / 진수 to 진수
풀이 : a진수 to 10진수 / 10진수 to b진수
 */
public class TransformationOfNumberSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String n = br.readLine();
        //a진수 to 10진수
        int decimal = 0;
        for(int i = 0; i < n.length(); i++){
            decimal = decimal * a + n.charAt(i) - '0';
        }

        //10진수 to b진수
        int[] digit = new int[decimal];
        int cnt = 0;
        while(true){
            if(decimal < b){
                digit[cnt++] = decimal;
                break;
            }
            digit[cnt++] = decimal % b;
            decimal /= b;
        }
        for(int i = cnt - 1; i >= 0; i--){
            System.out.print(digit[i]);
        }
    }
}
