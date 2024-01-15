package CodingTest.SWEA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Mode {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			Map<Integer, Integer> score = new HashMap<>();
			int n = 1000;
			while (n-- > 0) {
				int key = sc.nextInt();
				score.put(key, score.getOrDefault(key, 0) + 1);
			}

			List<Integer> keySet = new ArrayList<>(score.keySet());
			keySet.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					int c = score.get(o2).compareTo(score.get(o1));
					if(c == 0) {
						return o2 - o1;
					}
					return c;
				}
			});
			System.out.println("#" + test + " " + keySet.get(0));
		}
	}
}
