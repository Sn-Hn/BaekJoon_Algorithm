package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

최소비용 구하기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초	128 MB	29614	10128	5884	32.707%
문제
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 
우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 
A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.

입력
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 
그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 
버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 
출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

예제 입력 1 
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
예제 출력 1 
4


*/

public class GetMinimumCost_1916 {
	private static final int INF = 1000000000;
	// N : 도시의 개수, M : 버스의 개수
	private static int N, M;
	private static int sp[];
	private static boolean visited[];
	private static List<List<Node>> list;
	
	static class Node implements Comparable<Node> {
		int busIndex, cost;
		public Node(int busIndex, int cost) {
			this.busIndex = busIndex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		sp = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(sp, INF);
		
		// list 선언
		list = new ArrayList<List<Node>>();
		// 버스의 정점이 1부터 주어지니 미리 선언
		list.add(new ArrayList<Node>());
		
		for(int i = 1; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(list, sp, start);
		
		System.out.println(sp[end]);
		
		br.close();
	}
	
	private static void dijkstra(List<List<Node>> list, int[] cost, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		// 자기 자신은 0
		cost[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int now = pq.poll().busIndex;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(cost[node.busIndex] > cost[now] + node.cost) {
					cost[node.busIndex] = cost[now] + node.cost;
					pq.add(new Node(node.busIndex, cost[node.busIndex]));
				}
			}
			
		}
		
		
	}
}
