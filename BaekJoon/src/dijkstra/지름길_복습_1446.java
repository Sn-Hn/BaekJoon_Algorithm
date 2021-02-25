package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 지름길_복습_1446 {
	private static int N, D;
	private static List<List<Node>> list;
	private static boolean visited[];
	private static int distance[];
	private static int INF = Integer.MAX_VALUE;
	
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
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[D+1];
		distance = new int[D+1];
		list = new ArrayList<List<Node>>();
		
		Arrays.fill(distance, INF);
		list.add(new ArrayList<>());
		
		for(int i = 0; i < D; i++) {
			list.add(new ArrayList<Node>());
			list.get(i).add(new Node(i+1, 1));
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a > D || b > D) continue;
			
			list.get(a).add(new Node(b, c));
		}
		
		dijstra();
		
		System.out.println(distance[D]);
		
		br.close();
	}
	
	private static void dijstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		distance[0] = 0;
		
		pq.add(new Node(0, 0));
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}
		
	}
}
