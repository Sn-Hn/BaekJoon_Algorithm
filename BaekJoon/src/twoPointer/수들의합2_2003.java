package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

수들의 합 2 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초	128 MB	20393	9990	6664	50.241%
문제
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.

예제 입력 1 
4 2
1 1 1 1
예제 출력 1 
3
예제 입력 2 
10 5
1 2 3 4 2 5 3 1 1 2
예제 출력 2 
3

*/

public class 수들의합2_2003 {
	private static int N, M;
	private static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(twoPointer2());
		
		br.close();
	}
	
	private static int twoPointer() {
		int end = 0;
		int sum = 0;
		int result = 0;
		
		for(int start = 0; start < N; start++) {
			while(end < N && sum < M) {
				sum += arr[end];
				end++;
			}
			if(sum == M) {
				result++;
			}
			sum -= arr[start];
		}
		
		return result;
	}
	
	private static int twoPointer2() {
		int start = 0;
		int end = 0;
		int sum = 0;
		int result = 0;
		
		while(end <= N) {
			if(sum < M) {
				sum += arr[end];
				end++;
			}else {
				sum -= arr[start];
				start++;
			}
			
			if(sum == M) {
				result += 1;
			}
		}
		return result;
	}
}
