package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
정점 번호는 1번부터 N번까지이다.

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.

첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

*/

/* DFS와 BFS 기본 문제 인접행렬을 이용 */
public class DFS_BFS_AdjacencyMatrix_1260 {
	private static int[][] ad;
	private static boolean[] visit;
	private static int n;		// 정점의 개수
	private static int m;		// 간선의 개수
	private static int v;		// 시작할 노드의 번호

	public static void dfs(int i) {
		visit[i] = true; // 함수 호출 시, visit 했음을 표시
		System.out.print(i + " ");

		for (int j = 1; j < n + 1; j++) {
			if (ad[i][j] == 1 && visit[j] == false) { // j를 방문하지 않았으면 j를 방문한다.
				// 내가 찾은 경로가 만약에 다른 경로가 있으면 바로 다음 곳으로 이동시키고 만약에 없으면,
				// 다시 리커해서 돌아오는 방식임.

				dfs(j);
			}
		}
	}

	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visit[i] = true;
		// 방문한 위치는 알아야하니까, 그것을 체크하기 위해서 visit가 필요.
		while (!q.isEmpty()) {
			int temp = q.poll();
			// 첫번째 방문한 위치는 빼주기로 한다.
			System.out.print(temp + " ");
			for (int k = 1; k <= n; k++) {
				if (ad[temp][k] == 1 && visit[k] == false) {
					q.offer(k);
					visit[k] = true; // true라면 방문을 한거임. ㅇㅇ
				}
			}
		}
	}

	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		StringTokenizer st = new StringTokenizer(s, " ");
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		v = Integer.parseInt(st.nextToken());
		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		
		ad = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		for (int j = 0; j < n + 1; j++) {
			Arrays.fill(ad[j], 0);
		}
		Arrays.fill(visit, false);
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			ad[a][b] = 1;
			ad[b][a] = 1;
		}
		dfs(v);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v);
	}
}
