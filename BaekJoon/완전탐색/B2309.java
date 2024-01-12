package CodingTest.BaekJoon.완전탐색;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

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
}
