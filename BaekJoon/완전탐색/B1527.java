package CodingTest.BaekJoon.완전탐색;

import java.io.*;
import java.util.*;
public class B1527 {
    static long a,b, result;
    public static void dfs(long num){
        if(num > b){
            return;
        }
        if(num >= a){
            result++;
        }

        dfs(num*10+4);
        dfs(num*10+7);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(4);
        dfs(7);
        System.out.println(result);

    }
}
