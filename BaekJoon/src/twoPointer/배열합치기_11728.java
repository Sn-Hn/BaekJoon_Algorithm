package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열합치기_11728 {
	private static int N, M;
	private static int arrA[];
	private static int arrB[];
	private static int result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrA = new int[N];
		arrB = new int[M];
		result = new int[N+M];
		int idx = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
			result[idx++] = arrA[i]; 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
			result[idx++] = arrB[i];
		}
		
		Arrays.sort(result);
		
		twoPointer();
//		StringBuilder sb = new StringBuilder();
//		for(int i : result) sb.append(i + " ");
//		
//		System.out.println(sb.toString());
		
		
		
		br.close();
	}
	
	private static void twoPointer() {
		int startA = 0;
		int startB = 0;
		int i = 0;
		while(startA < N && startB < M) {
			if(arrA[startA] < arrB[startB] && startA < N) {
				result[i] = arrA[startA];
				startA++;
				i++;
			}else if(arrA[startA] >= arrB[startB] && startB < M){
				result[i] = arrB[startB];
				startB++;
				i++;
			}
		}
		
		for(int j = startA; j < N; j++) {
			result[i] = arrA[j];
			i++;
		}
		for(int j = startB; j < M; j++) {
			result[i] = arrB[j];
			i++;
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int j : result) sb.append(j + " ");
		
		System.out.println(sb.toString());
	}
}
