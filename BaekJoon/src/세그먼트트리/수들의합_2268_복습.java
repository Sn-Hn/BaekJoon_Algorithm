package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합_2268_복습 {
	private static int N;
	private static int M;
	private static int[] arr;
	private static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		tree = new long[N * 4];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			if (a == 0) {
				if (b > c) {
					sb.append(sum(1, N, 1, c, b)).append("\n");
					continue;
				}
				sb.append(sum(1, N, 1, b, c)).append("\n");
			}else {
				update(1, N, 1, b, c);
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	private static long sum(int start, int end, int node, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		
		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	private static long update(int start, int end, int node, int index, int value) {
		if (start > index || end < index) {
			return tree[node];
		}
		
		if (start == end && start == index) {
			return tree[node] = value;
		}
		
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, index, value) + update(mid + 1, end, node * 2 + 1, index, value);
	}
}
