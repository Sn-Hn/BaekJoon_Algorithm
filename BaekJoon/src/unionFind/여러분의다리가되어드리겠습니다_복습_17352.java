package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러분의다리가되어드리겠습니다_복습_17352 {
	private static int N;
	private static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		
		for(int i = 1; i <= N; i++) parent[i] = i;
		
		for(int i = 0; i < N-2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		for(int i = 1; i <= N; i++) {
			if(parent[i] == i) {
				System.out.print(i + " ");
			}
		}
		
		
		br.close();
	}
	
	private static boolean findParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		else return false;
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
}
