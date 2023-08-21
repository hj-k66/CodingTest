package CodingTest.CodeTree.novicemid.simulation2.ArrayRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhoWillPay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] student = new int[n+1];
        int ans = -1;
        for(int i = 0; i < m; i++){
            int studentNum = Integer.parseInt(br.readLine());
            student[studentNum]++;
            if(student[studentNum] >= k){
                ans = studentNum;
                break;
            }
        }
        System.out.println(ans);
    }
}
