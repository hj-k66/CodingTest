package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 1244 스위치 켜고 끄기
11608KB | 	64ms
[문제 해석]
1 : 스위치 켜져 있음
0 : 스위치 꺼져 있음
남(1) : 스위치 번호가 자기가 받은 수의 배수이면, 삳태 바꿈
여(2) : 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭(상태가 같아야함)이면서 가장 많은 스위치를 포함하는 구간 스위치 모두 바꿈
=> 구간 내 스위치 갯수는 항상 홀수
스위치 번호는 1부터
N(스위치 갯수) : 100이하
학생수 : 100이하
[문제 풀이]
스위치 상태 바꾸기는 XOR 연산으로 해결
=> 두 비트가 다르면 1 반환, 같으면 0 반환
=> 타겟 스위치 ^ 1 => 꺼져있으면 1로, 켜져있으면 0으로
 */
public class B1244_스위치켜고끄기 {
    static int[] lightSwitch;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lightSwitch = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            lightSwitch[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < studentNum; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender == 1){
                //남학생
                switchWithMale(num);
            }
            if(gender == 2){
                //여학생
                switchWithFeMale(num);
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(lightSwitch[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);

    }

    static void switchWithMale(int num){
        //num의 배수의 스위치 상태 바꾸기
        for(int i = num; i <= N; i += num){
            lightSwitch[i] = lightSwitch[i]^1;
        }
    }

    static void switchWithFeMale(int num){
        // 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭(상태가 같아야함)이면서 가장 많은 스위치를 포함하는 구간 스위치 모두 바꿈
        //=> 구간 내 스위치 갯수는 항상 홀수
        lightSwitch[num] = lightSwitch[num]^1;
        for(int i = 1; i <= N/2; i++){
            int left = num - i;
            int right = num + i;
            if(left < 1 || right > N || lightSwitch[left] != lightSwitch[right]) break;

            if(lightSwitch[left] == lightSwitch[right]){
                lightSwitch[left] = lightSwitch[left] ^1;
                lightSwitch[right] = lightSwitch[right]^1;
            }
        }
    }
}
