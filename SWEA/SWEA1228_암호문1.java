package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
[SWEA] 1228 암호문1
18,676 kb | 113 ms
[문제 풀이]
- 암호문의 길이가 가변적으로 변하고, 중간 삽입을 진행해야하므로 컬렉션을 사용한다. (List)
- list.add(int index, <?>element) : i위치에 element 추가하는 연산
- list.addAll(int index, Collection<?> c) : i위치에 list(컬렉션) c를 추가하는 연산
 */
public class SWEA1228_암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());    //원본 암호문의 길이
            // 암호문 길이 가변적
            // 중간 삽입
            st = new StringTokenizer(br.readLine());
            List<String> password = new ArrayList<>();
            for(int i = 0; i < N; i++){
                password.add(st.nextToken());
            }

            int commandCnt = Integer.parseInt(br.readLine());   //명령어 갯수
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < commandCnt; i++){
                String c = st.nextToken();
                int index = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for(int j = 0; j < y; j++){
                    password.add(index + j, st.nextToken());
                }
            }
            //출력
            sb.append('#').append(tc).append(' ');
            for(int i = 0; i < 10; i++){
                sb.append(password.get(i)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
