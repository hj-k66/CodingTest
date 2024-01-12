package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;

/*
 * [BOJ] 2605 줄 세우기
 * 최적화
 * - ArrayList이용 -> 입력받자마자 줄 세우기
 * - answer.add(answer.size() - num, i+1);
 */
public class B2605 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[n];
		for(int stdt = 0; stdt < n; stdt++) {
			int number = arr[stdt];
			for(int i = stdt; i > stdt-number;i-- ) {
				answer[i] = answer[i-1];
			}
			answer[stdt - number] = stdt + 1;
		}
		
		//출력
		for(int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public void otherSolution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> answer = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) answer.add(i+1);
			else answer.add(answer.size() - num, i+1);
		}
		
		//출력
		for(int i : answer) {
			System.out.print(i + " ");
		}
	}
}
