package CodingTest.BaekJoon.이분탐색_삼분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
[BOJ] 2110 공유기 설치
solution : 탐색 범위 = 거리 >> 거리에 대해 이분탐색
>> 해당 거리에 대해 설치 가능한 공유기 개수로 판단
 */
public class B2110 {
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for(int i = 0; i < house.length; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int start = 1; //거리의 최소값
        int end = house[n-1] - house[0] + 1; //거리의 최대값

        while(start < end){
            int mid = (start + end) / 2;
            if(canInstall(mid) < c){
                /*
                mid 거리에 대해 설치 가능한 공유기 갯수가 못 미치면,
                거리를 좁힌다.
                */
                end = mid;
            }else{
                /*
                설치 가능한 공유기 개수가 기준보다 크거나 같으면,
                거리를 벌린다. >> 거리를 벌려 최소거리를 늘이기 위해
                 */
                start = mid + 1;
            }
        }

        System.out.println(start - 1);

    }

    //distance에 대해 설치 가능한 공유기 갯수 찾기
    static int canInstall(int distance){
        //첫번째 집은 무조건 설치
        int count = 1;
        int lastLocated = house[0];

        for(int i = 1; i < house.length; i++){
            int locate = house[i];
            /*
            현재 탐색하는 집의 위치와 직전에 설치한 집의 위치 거리 구하기
            distance보다 크거나 같을 때 공유기 설치 >> 갯수 늘이기, 마지막 설치 위치 갱신
             */
            if(locate - lastLocated >= distance){
                count++;
                lastLocated = locate;
            }
        }
        return count;
    }
}
