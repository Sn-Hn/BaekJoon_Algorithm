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

최단경로 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	71170	18413	8818	23.236%
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. 
(1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. 
u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

예제 입력 1 
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
예제 출력 1 
0
2
3
7
INF

*/

public class ShortestPath_PriorityQueue_1753 {
	private static int INF = 1000000000;
	private static int V, E;
	private static int[] sp;
	private static boolean[] visited;
	
	// 이중 List
	// ex) 정점을 저장할 List 안의 정점 1에서 2 ~ V까지의 최단거리를 저장할 List (정점과 정점 사이의 거리값(가중치)를 저장할 Node)
	private static List<List<Node>> list;
	
	// Node 클래스
	static class Node implements Comparable<Node> {
		// index : 정점, distance : 거리
		int index, distance;
		
		// 생성자로 초기화
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		// Comparable Override
		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점의 개수
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		sp = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList<List<Node>>();
		
		// list가 0부터 시작하지 않고 1부터 시작하기 위해 1개 미리 선언해 놓음
		// 즉, list.get(0)을 넣어놓고 시작
		list.add(new ArrayList<Node>());
		
		Arrays.fill(sp, INF);
		
		// list안의 list선언
		for(int i = 1; i <= V; i++) {
			list.add(new ArrayList<Node>());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		// 위에서 list.add()를 한 번 해 놓았으니 1부터 V까지
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
		}
		
		dijkstra(list, sp, K);
		
		for(int i = 1; i <= V; i++) {
			if(sp[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(sp[i]);
			}
		}
		
		br.close();
	}
	
	private static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		// 최단 경로를 저장할 int형 배열
		distance[start] = 0;
		
		pq.add(new Node(start, 0));		// Node (1, 0)저장
		
		while(!pq.isEmpty()) {
			// 현재 정점의 index(위치)
			int now = pq.poll().index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			// 현재 정점의 모든 경로까지의 최단경로 (index와 distance)
			for(Node node : list.get(now)) {
				// distance[]는 현재 저장되어 있는 가장 최단 거리
				// 즉 distance[index]보다 현재(now)까지의 최단경로(distance[now]) + 정점까지의 거리가 작다면
				// distance[index] 갱신
				if(distance[node.index] > distance[now] + node.distance) {
					distance[node.index] = distance[now] + node.distance;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
			
		}
		
	}

}
