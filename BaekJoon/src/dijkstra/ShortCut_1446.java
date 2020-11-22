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

지름길 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	1103	451	353	40.951%
문제
매일 아침, 세준이는 학교에 가기 위해서 차를 타고 D킬로미터 길이의 고속도로를 지난다.
이 고속도로는 심각하게 커브가 많아서 정말 운전하기도 힘들다. 
어느 날, 세준이는 이 고속도로에 지름길이 존재한다는 것을 알게 되었다. 
모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.

세준이가 운전해야 하는 거리의 최솟값을 출력하시오.

입력
첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다. 
N은 12 이하이고, D는 10,000보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다. 
모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 지름길의 시작 위치는 도착 위치보다 작다.

출력
세준이가 운전해야하는 거리의 최솟값을 출력하시오.

예제 입력 1 
5 150
0 50 10
0 50 20
50 100 10
100 255 10
155 170 90
예제 출력 1 
70

*/

public class ShortCut_1446 {
	private static final int INF = 1000000000;
	// N : 지름길의 개수, D : 고속도로의 길이
	private static int N, D;
	private static boolean visited[];
	private static List<List<Node>> list;
	private static int[] min;
	
	static class Node implements Comparable<Node> {
		int index, distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
			
		list = new ArrayList<List<Node>>();
		min = new int[D+1];
		visited = new boolean[D+1];
		
		Arrays.fill(min, INF);
		
		for(int i = 0; i <= D; i++) {
			list.add(new ArrayList<Node>());
			list.get(i).add(new Node(i+1, 1));
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 이것때문에 런타임에러남...
			// 리얼 30분 헤맸다..
			if(a > D) continue;
			
			list.get(a).add(new Node(b, c));
		}
		
		dijkstra(list, min, 0);
		
		System.out.println(min[D]);
		
		br.close();
	}
	
	private static void dijkstra(List<List<Node>> list, int[] min, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		min[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node node : list.get(now)) {
				if(node.index > D) {
					continue;
				}
				if(min[node.index] > min[now] + node.distance) {
					min[node.index] = min[now] + node.distance;
					pq.add(new Node(node.index, min[node.index]));
				}
			}
			
			
		}
		
		
	}
	
}
