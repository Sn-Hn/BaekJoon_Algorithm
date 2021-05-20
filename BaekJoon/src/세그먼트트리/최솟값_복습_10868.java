package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값_복습_10868 {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] tree;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		tree = new int[N * 4];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1, N, 1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(min(1, N, 1, a, b) + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	// 트리 초기화
	private static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		// 트리를 재귀로 초기화 한다.
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}
	
	private static int min(int start, int end, int node, int left, int right) {
		if(left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		
		// 원하는 구간이 시작과 끝과 관계 없다면 tree[node] 리턴
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
	}
}
