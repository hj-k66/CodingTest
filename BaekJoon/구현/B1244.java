package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //스위치 갯수
        int[] switches = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for(int cnt = 0; cnt < studentCnt; cnt++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender == 1){
                for(int i = num; i <= n; i+=num){
                    switches[i] ^= 1;
                }
            }else {
                switches[num] ^= 1;
                int start = num;
                int end = num;

                for(int i = 1; num - i >= 1 && num + i <= n; i++){
                    if(switches[num - i] == switches[num+i]){
                        switches[num-i] ^= 1;
                        switches[num+i] ^= 1;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(switches[i] + " ");
            if (i % 20 == 0 && i != n) {
                System.out.println();
            }
        }
    }
}
