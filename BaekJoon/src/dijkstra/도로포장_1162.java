package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도로포장_1162 {
	private static int N, M, K;
	private static List<List<Node>> list;
	private static long time[][];
	private static long INF = Long.MAX_VALUE;
	
	private static class Pair implements Comparable<Pair>{
		int idx, step;
		long time;
		public Pair(int idx, int step, long time) {
			this.idx = idx;
			this.step = step;
			this.time = time;
		}
		
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return (int)(time - o.time);
		}
	}
	
	private static class Node {
		int index;
		long time;
		public Node(int index, long time) { 
			this.index = index;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<List<Node>>();
		time = new long[N+1][K+1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(time[i], INF);			
		}
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		dijkstra();
		long result = INF;
		for(int i = 0; i <= K; i++) {
			result = Math.min(result, time[N][i]);
		}
		
		System.out.println(result);

		br.close();
	}
	
	private static void dijkstra() {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		time[1][0] = 0;
		q.add(new Pair(1, 0, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int now = p.idx;
			int step = p.step;
			
			if(time[now][step] < p.time) continue;
			
			for(Node node : list.get(now)) {
				if(step + 1 <= K && time[node.index][step+1] > time[now][step]) {
					time[node.index][step+1] = time[now][step];
					q.add(new Pair(node.index, step + 1, time[node.index][step + 1]));
				}
				
				if(time[node.index][step] > time[now][step] + node.time) {
					time[node.index][step] = time[now][step] + node.time;
					q.add(new Pair(node.index, step, time[node.index][step]));
				}
			}
			
		}
		
		
	}
}
