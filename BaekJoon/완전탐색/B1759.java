import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[BOJ] 1759 암호 만들기
	11684KB |	88ms
*/
public class B1759 {
    static int L;
    static int C;
    static String[] candidate;
    static String[] output;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        candidate = new String[C];
        for (int i = 0; i < C; i++) {
            candidate[i] = st.nextToken();
        }
        Arrays.sort(candidate);
        //로직
        output = new String[L];
        sb = new StringBuilder();
        comb(0, 0, 0, 0);

        System.out.println(sb);
    }

    static void comb(int idx, int start, int vowelCnt, int consonantCnt) {
        if (idx == L) {
            if (vowelCnt >= 1 && consonantCnt >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(output[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            output[idx] = candidate[i];
            if (output[idx].equals("a") || output[idx].equals("e")
                    || output[idx].equals("i") || output[idx].equals("o") || output[idx].equals("u")) {
                comb(idx + 1, i + 1, vowelCnt + 1, consonantCnt);
            } else {
                comb(idx + 1, i + 1, vowelCnt, consonantCnt + 1);
            }
        }
    }
}
