package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/*

N과 M (12) 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	4007	3200	2702	81.705%
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
4 4 2
예제 출력 1 
2
4
예제 입력 2 
4 2
9 7 9 1
예제 출력 2 
1 1
1 7
1 9
7 7
7 9
9 9
예제 입력 3 
4 4
1 1 2 2
예제 출력 3 
1 1 1 1
1 1 1 2
1 1 2 2
1 2 2 2
2 2 2 2

*/

public class NAndM12_15666 {
	private static int N, M;
	private static int arr[];
	private static int result[];
	private static StringBuilder sb = new StringBuilder();
	private static LinkedHashSet<String> list = new LinkedHashSet<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			bw.write(it.next() + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	private static void dfs(int index, int depth) {
		if(depth == M) {
			for(int i : result) {
				sb.append(i + " ");
			}
			list.add(sb.toString());
			sb.setLength(0);
			
			return;
		}
		
		for(int i = index; i < N; i++) {
			result[depth] = arr[i];
			dfs(i, depth+1);
		}
		
	}
}
