package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_복습_1916 {
	private static int N, M;
	private static List<List<Node>> list;
	private static boolean visited[];
	private static int distance[];
	private static int start, end;
	private static int INF = Integer.MAX_VALUE;
	
	private static class Node implements Comparable<Node>{
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
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<List<Node>>();
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		Arrays.fill(distance, INF);
		
		list.add(new ArrayList<Node>());
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();

		br.close();
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		// 자기 자신은 0으로 초기화
		distance[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}
		
		System.out.println(distance[end]);
	}
	
}
