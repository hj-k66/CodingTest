package CodingTest.BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[BOJ] 1759 암호 만들기
12056KB |	72ms
[문제 풀이]
조합 구성하기 전 원본 문자들을 미리 정렬해놓고 조합을 구성
 */
public class B1759_암호만들기 {

    static int L;
    static int C;
    static String[] alphabet;
    static String[] output;
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alphabet[i] = st.nextToken();
        }

        //로직
        // L개의 알파벳으로 구성한 후 최소 한 개의 모등과 최소 2개의 자음으로 구성되어있는지 확인
        Arrays.sort(alphabet);
        output = new String[L];
        comb(0,0,0,0);

        System.out.println(sb);

    }

    static void comb(int idx, int start, int vowelCnt, int consonantCnt){
        //가지치기
        if(L - vowelCnt < 2) return;
        if(idx == L){
            // 조건 검사
            if(vowelCnt >= 1 && consonantCnt >= 2){
                for(int i = 0; i < L; i++){
                    sb.append(output[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i = start; i < C; i++){
            output[idx] = alphabet[i];

            if(isVowel(output[idx])) comb(idx+1, i+1, vowelCnt + 1, consonantCnt);
            comb(idx+1, i+1, vowelCnt, consonantCnt+1);
        }

    }

    static boolean isVowel(String s){
        for(String vowel : vowels){
            if(vowel.equals(s)) return true;
        }
        return false;
    }
}
