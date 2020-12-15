package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*

모든 순열 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	14211	8262	6102	59.008%
문제
N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다. 

출력
첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

예제 입력 1 
3
예제 출력 1 
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

*/

public class AllSequence_10974 {
	private static int arr[];
	private static boolean visited[];
	private static int N;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
//		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> result = new ArrayList<Integer>();
//		
//		for(int i = 1; i <= N; i++) {
//			list.add(i);
//		}
		
		
		// 메모리와 시간이 많이듬
//		dfs(list, result, N, N);
		
		sol(0);
		System.out.println(sb);
		
		br.close();
	}
	
	private static void sol(int depth) {
		if(depth == N) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				sol(depth+1);
				visited[i] = false;
			}
		}
	}
	
	// List를 이용한 permutation(순열)
	private static void dfs(List<Integer> list, List<Integer> result, int n, int cnt) {
		if(cnt == 0) {
			for(int i : result) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			result.add(list.remove(i));
			dfs(list, result, n-1, cnt-1);
			list.add(i, result.remove(result.size()-1));
		}
	}
}
