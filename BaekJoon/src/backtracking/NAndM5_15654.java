package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*

N과 M (5) 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	7626	5659	4486	74.002%
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
4 5 2
예제 출력 1 
2
4
5
예제 입력 2 
4 2
9 8 7 1
예제 출력 2 
1 7
1 8
1 9
7 1
7 8
7 9
8 1
8 7
8 9
9 1
9 7
9 8
예제 입력 3 
4 4
1231 1232 1233 1234
예제 출력 3 
1231 1232 1233 1234
1231 1232 1234 1233
1231 1233 1232 1234
1231 1233 1234 1232
1231 1234 1232 1233
1231 1234 1233 1232
1232 1231 1233 1234
1232 1231 1234 1233
1232 1233 1231 1234
1232 1233 1234 1231
1232 1234 1231 1233
1232 1234 1233 1231
1233 1231 1232 1234
1233 1231 1234 1232
1233 1232 1231 1234
1233 1232 1234 1231
1233 1234 1231 1232
1233 1234 1232 1231
1234 1231 1232 1233
1234 1231 1233 1232
1234 1232 1231 1233
1234 1232 1233 1231
1234 1233 1231 1232
1234 1233 1232 1231

*/

public class NAndM5_15654 {
	private static int N, M;
	private static int arr[];
	private static int result[];
	private static boolean visited[];
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb);
		
		br.close();
	}
	
	private static void dfs(int depth) {
		if(depth == M) {
			for(int i : result) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++ ) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
	}
}
