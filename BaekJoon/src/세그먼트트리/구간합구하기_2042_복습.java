package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기_2042_복습 {
	private static int N;
	private static int M;
	private static int K;
	private static int[] arr;
	private static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		tree = new long[N * 4];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		initSegmentTree(1, N, 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				update(1, N, 1, b, c);
			}else {
				sb.append(sum(1, N, 1, b, c)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	private static long initSegmentTree(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = initSegmentTree(start, mid, node * 2) + initSegmentTree(mid + 1, end, node * 2 + 1);
	}
	
	private static long sum(int start, int end, int node, int left, long right) {
		if (left > end || right < start) {
			return 0;
		}
		
		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	private static long update(int start, int end, int node, int index, long value) {
		if (start > index || end < index) {
			return tree[node];
		}
		
		if (start == end) {
			return tree[node] = value;
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = update(start, mid, node * 2, index, value) + update(mid + 1, end, node * 2 + 1, index, value);
	}
	
}
