package CodingTest.BaekJoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 12891 DNA 비밀번호
21580KB |	168ms
[문제 해석]
DNA 문자열 : A,C,G,T만 존재하는 문자열
목표 : DNA문자열과 부분문자열의 길이. 각 문자가 등장해야하는 횟수가 주어졌을 때, 만들 수 있는 비밀번호 종류 수
- 부분문자열의 위치가 다르면 문자가 같더라도 다른 문자열로 취급
DNA 문자열 길이 S, 부분문자열 길이 P : 100만
[문제 풀이]
- 슬라이딩 윈도우 => 부분 배열의 길이가 고정적이므로, 포인터 변수를 2개 쓸 필요 x
1. dnaMin에 요구하는 ACGT의 개수 담아놓음
dnaMin['A'] : 인덱스가 알파벳 문자 되도록
2. 뽑은 문자열의 문자 갯수를 dnaCnt에 담기
- 문자열 뽑을 때는 맨앞 문자(start)의 갯수를 빼고, 맨 뒤(end) + 1 문자 갯수를 추가함
3. dnaCnt와 dnaMin의 ACGT 갯수 비교
 */
public class B12891_DNA비밀번호 {
    static int[] dnaCnt;
    static int[] dnaMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dnaString = new char[S];
        String dna = br.readLine();
        for(int i = 0; i < S; i++){
            dnaString[i] = dna.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        dnaMin = new int['Z'+1];
        dnaMin['A'] = Integer.parseInt(st.nextToken());
        dnaMin['C'] = Integer.parseInt(st.nextToken());
        dnaMin['G'] = Integer.parseInt(st.nextToken());
        dnaMin['T'] = Integer.parseInt(st.nextToken());

        dnaCnt = new int['Z'+1];
        for(int i = 0; i < P; i++){
            dnaCnt[dnaString[i]]++;
        }
        int passwordCnt = 0;
        if(canPassword()) passwordCnt++;

        for(int start = 0; start < S-P; start++){
            dnaCnt[dnaString[start]]--;
            dnaCnt[dnaString[start + P]]++;
            if(canPassword()) passwordCnt++;


        }
        System.out.println(passwordCnt);
    }

    static boolean canPassword(){
        if(dnaCnt['A'] < dnaMin['A']) return false;
        if(dnaCnt['C'] < dnaMin['C']) return false;
        if(dnaCnt['G'] < dnaMin['G']) return false;
        if(dnaCnt['T'] < dnaMin['T']) return false;
        return true;
    }

    /*
    배열 하나만 쓰는 방법
    - 문자열을 카운트할 때 +가 아닌 -하기
    => 유효한 암호 판별 : ACGT 인덱스 값이 모두 0보다 작아야 한다.
     */

    static int[] alphaCnt = new int['Z' + 1];
    static void otherSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   //임의의 DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());   // 부분문자열 길이

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        alphaCnt['A'] = Integer.parseInt(st.nextToken());
        alphaCnt['C'] = Integer.parseInt(st.nextToken());
        alphaCnt['G'] = Integer.parseInt(st.nextToken());
        alphaCnt['T'] = Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i = 0; i < P; i++){
            alphaCnt[str.charAt(i)]--;
        }
        // 비밀번호 유효성 체크
        if(isValidACGT()) answer++;

        // 슬라이딩 윈도우
        for(int i = 0; i < S - P; i++){
            // 맨 앞 문자 카운트에서 제거
            alphaCnt[str.charAt(i)]++;
            //맨 뒤 문자 추가
            alphaCnt[str.charAt(i + P)]--;
            //비밀번호 유효성 체크
            if(isValidACGT()) answer++;
        }

        System.out.println(answer);
    }

    static boolean isValidACGT(){
        String acgt = "ACGT";
        for(int i = 0; i < 4; i++){
            if(alphaCnt[acgt.charAt(i)] > 0) return false;
        }
        return true;
    }
}
