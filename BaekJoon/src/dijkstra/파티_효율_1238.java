package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_효율_1238 {
	private static int N, M, X;
	private static List<List<Node>> list;
	private static List<List<Node>> list2;
	private static int distance[];
	private static int d[];
	private static int INF = Integer.MAX_VALUE;
	private static int result[];	
	
	private static class Node implements Comparable<Node> {
		int index, distance;
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return distance - o.distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<List<Node>>();
		list2 = new ArrayList<List<Node>>();
		distance = new int[N+1];
		d = new int[N+1];
		result = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
			list2.add(new ArrayList<Node>());
		}
		Arrays.fill(distance, INF);
		Arrays.fill(d, INF);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list2.get(b).add(new Node(a, c));
		}
		
		solve(list, distance, X);
		solve(list2, d, X);
		
		for(int i = 1; i <= N; i++) {
			result[i] = d[i] + distance[i];
		}
		
		Arrays.sort(result);
		
		System.out.println(result[N]);
		
		br.close();
	}
	
	private static void solve(List<List<Node>> list, int distance[], int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		boolean visited[] = new boolean[N+1];
		distance[start] = 0;
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int now = n.index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance;
					q.add(new Node(node.index, distance[node.index]));
				}
			}
		}
	}

}
