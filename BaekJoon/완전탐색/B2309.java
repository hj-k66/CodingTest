package CodingTest.BaekJoon.완전탐색;

import java.io.*;
import java.util.*;

/*
 * [BOJ] 2309 일곱 난쟁이
 * 내풀이 : 2개를 골라 제외했을 때 100이 되는 수들을 구한다.
 * 최적화
 * 1. j를 i+1부터 진행
 * 2. 9개의 총합을 구하고 총합에서 2개원소를 뺀 결과가 100
 * 3. 해당 i,j를 0으로 설정 후 배열 정렬 후 2부터 출력
 */
public class B2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		List<Integer> answer = new ArrayList<>();
		A: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;
				answer = new ArrayList<>();
				int sum = 0;
				for (int k = 0; k < 9; k++) {
					if (k == i || k == j)
						continue;
					sum += arr.get(k);
					answer.add(arr.get(k));
				}
				if (sum == 100) {
					break A;
				}
			}
		}

		Collections.sort(answer);
		for (int i = 0; i < 7; i++) {
			System.out.println(answer.get(i));
		}

	}
	
	public void otherSolution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for (int k = 2; k < 9; k++) {
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
	}
}
