package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountCircleGroups_복습_10216 {
	private static int T, N;
	private static int parent[];
	private static int position[][];
	private static int result[];
	private static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N+1];
			visited = new boolean[N+1];
			result = new int[2];
			position = new int[N+1][3];
			for(int j = 1; j <= N; j++) {
				parent[j] = j;
				StringTokenizer st = new StringTokenizer(br.readLine());
				position[j][0] = Integer.parseInt(st.nextToken());
				position[j][1] = Integer.parseInt(st.nextToken());
				position[j][2] = Integer.parseInt(st.nextToken());
			}
			backtracking(0, 0);
			int count = 0;
			
			for(int j = 1; j <= N; j++ ) {
				if(parent[j] == j) {
					count++;
				}
			}
			
			System.out.println(count);
			
		}
		
		br.close();
	}
	
	private static void backtracking(int idx, int depth) {
		if(depth == 2) {
			union(result[0], result[1]);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = i+1;
				backtracking(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
	
	private static void union(int a, int b) {
		double h = Math.abs(position[a][0] - position[b][0]);
		double w = Math.abs(position[a][1] - position[b][1]);
		double r = Math.sqrt(h*h + w*w); 
		double dis = position[a][2] + position[b][2];
		
		a = find(a);
		b = find(b);
		if(r <= dis) {
			// a와 b의 부모를 찾는 것
			// 부모 넣어주기
			if(a < b) parent[b] = a;
			else parent[a] = b;			
		}
	}
}
