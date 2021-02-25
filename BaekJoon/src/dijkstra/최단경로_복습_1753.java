package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_복습_1753 {
	private static int V, E, K;
	private static List<List<Node>> list;
	private static int distance[];
	private static boolean visited[];
	
	private static int INF = Integer.MAX_VALUE;
	
	private static class Node implements Comparable<Node> {
		int index, distance;
		private Node(int index, int distance) {
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		list = new ArrayList<List<Node>>();
		
		list.add(new ArrayList<Node>());
		
		for(int i = 0; i < V; i++) {
			list.add(new ArrayList<Node>());
		}
		
		Arrays.fill(distance, INF);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
		}
		
		dijkstra();
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);				
			}
		}
		
		br.close();
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		distance[K] = 0;
		
		pq.add(new Node(K, 0));		// 0에서 K로 가는 것은 0
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				// 최단 경로 배열의 현재까지의 최단거리가 
				if(distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}
		
	}
}
