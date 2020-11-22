package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

// 가장 기본이 되는 다익스트라..
// 하지만 이렇게 되면 메모리, 시간 초과난다.
// 우선순위 큐로 풀어보자
public class ShortestPath_Basic_1753 {
	private static int INF = 1000000000;
	private static int V, E, K;
	private static int[][] graph;
	private static boolean[] visited;
	// 최단 거리
	private static int[] sp;
	
	// 가장 최소 거리를 가지는 정점을 반환
	private static int getSmallIndex() {
		int min = INF;
		int index = 0;
		for(int i = 1; i <= V; i++) {
			if(sp[i] < min && !visited[i]) {
				min = sp[i];
				index = i;
			}
		}
		return index;
	}
	
	// dijkstra 수행
	private static void dijkstra(int start) {
		
		// 시작점의 모든 경로들을 최단거리 배열에 넣는다.
		for(int i = 1; i <= V; i++) {
			sp[i] = graph[start][i];
		}
		// 방문처리
		visited[start] = true;
		
		// 정점의 개수-2 번 반복 (왜?)
		for(int i = 1; i <= V-2; i++) {
			// 현재 노드를 getSmallIndex함수를 통해 불러온다.
			// start와 연결되어있는 정점중 가중치가 제일 낮은 정점의 index를 불러온다.
			int current = getSmallIndex();
			visited[current] = true;
			
			// 1부터 V까지 반복
			for(int j = 1; j <= V; j++) {
				// 이 정점을 방문하지 않았다면
				if(!visited[j]) {
					// 현재 정점까지의 최단거리와 현재 정점에서 j까지의 가중치의 합이 최단거리 배열에 있는 값보다 작다면
					if(sp[current] + graph[current][j] < sp[j]) {
						// 최단거리를 갱신해준다.
						sp[j] = sp[current] + graph[current][j];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new int[V+1][V+1];
		visited = new boolean[V+1];
		sp = new int[V+1];
		
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(i != j && graph[i][j] == 0) {
					graph[i][j] = INF;
				}
			}
		}
		
		dijkstra(K);
		
		for(int i = 1; i <= V; i++) {
			if(sp[i] != INF) {
				System.out.print(sp[i] + " ");					
			}else {
				System.out.print("INF ");
			}
		}
		
//		for(int i = 1; i <= V; i++) {
//			for(int j = 1; j <= V; j++) {
//				if(graph[i][j] != INF) {
//					System.out.print(graph[i][j] + " ");					
//				}else {
//					System.out.print("INF ");
//				}
//			}
//			System.out.println();
//		}
		
		br.close();
	}
}






