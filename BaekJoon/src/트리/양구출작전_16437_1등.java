package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 양구출작전_16437_1등 {
	private static int N;
	private static long island[];
	private static Node nodes[];
	
	private static class Node {
		int n;
		Node next;
		
		public Node(int n, Node node) {
			this.n = n;
			next = node;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		island = new long[N+1];
		nodes = new Node[N+1];
		StringTokenizer st;
		
		for(int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			char ch = st.nextToken().charAt(0);
			if(ch == 'S') {
				island[i] = Integer.parseInt(st.nextToken());
			}else {
				island[i] = Integer.parseInt(st.nextToken()) * -1;
			}
			
			int node = Integer.parseInt(st.nextToken());
			nodes[node] = new Node(i, nodes[node]);
		}
		
		System.out.println(dfs(1));
		
		br.close();
	}
	
	private static long dfs(int n) {
		for(Node next = nodes[n]; next != null; next = next.next) {
			island[n] += dfs(next.n);
		}
		
		if(island[n] < 0) {
			return 0;
		}
		return island[n];
	}
}
