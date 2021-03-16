package 플로이드와샬;

import java.io.*;
import java.util.*;

public class 회의준비_운식님_2610 {
	static int INF = 10000;
	static int MAX = 0;
	static int K, E;
	static int[] parent;
	static int[][] dp;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		parent = new int[K+1];
		dp = new int[K+1][K+1];
		for (int i = 0; i < K + 1; i++) {
			parent[i] = i;
			Arrays.fill(dp[i], INF);
			dp[i][i] = 0;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			dp[u][v] = 1;
			dp[v][u] = 1;

			// 1 2
			// 2 3

			// 2 1
			// 2 3
			// 2-> 1, 2 ->3
			//
			if (find(u) != find(v)) {
				union(v, u);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		int p = find(parent[1]);
		list.add(p);
		for (int i = 1; i < K+1; i++) {
			if (find(parent[i]) != p) {
				p = find(parent[i]);
				if (!list.contains(p))
					list.add(p);
			}
		}

		for (int k = 1; k < K+1; k++) {
			for (int i = 1; i < K + 1; i++) {
				for (int j = 1; j < K + 1; j++) {
					if (dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}

		HashMap<Integer, pair> map = new HashMap<>();
		for (int commit = 1; commit < K+1; commit++) {
			int max = MAX;
			int who = commit;
			for (int i = 1; i < K+1; i++) {
				if (i == commit) continue;
				if (max < dp[commit][i] && dp[commit][i] != INF) {
					max = dp[commit][i];
//					who = i;
				}
			}
			
			System.out.println(find(who) + ", " + who + ", " + max);

			if (!map.containsKey(find(who))) {
				map.put(find(who), new pair(who, max));
			} else if (map.get(find(who)).value > max) {
				map.put(find(who), new pair(who, max));
			}
		}

		ArrayList<Integer> commit_list = new ArrayList<>();
		map.forEach((s1, s2) -> commit_list.add(s2.who));
		Collections.sort(commit_list);

//		map.forEach((s1, s2) -> System.out.println(s1+", "+s2.who+": "+ s2.value));
//		System.out.println();

		for (int i = 1; i < K + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				if (dp[i][j] == INF)
					System.out.print("9 ");
				else
					System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("*****");
		
		for(int i : parent) System.out.print(i + " ");
		System.out.println();

		str.append(list.size()).append("\n");
		commit_list.forEach(s -> str.append(s).append("\n"));
		System.out.print(str);
	}
	private static int find(int p) {
		if (parent[p] == p) return p;
		return parent[p] = find(parent[p]);
	}

	private static void union(int u, int v) {
		u = parent[u];
		v = parent[v];
		
		if(u < v) 
			parent[v] = u;
		else 
			parent[u] = v;			
		
	}
	private static class pair{
		int who, value;
		pair(int who, int value) {
			this.who = who;
			this.value = value;
		}
	}
}
/*
9
8
1 2
2 3
3 4
4 5
4 6
4 7
4 8
4 9
 */